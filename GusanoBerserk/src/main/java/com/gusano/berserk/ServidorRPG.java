package com.gusano.berserk;

import com.gusano.berserk.armaduras.CapaFuerza;
import com.gusano.berserk.armaduras.CascoCaballero;
import com.gusano.berserk.armaduras.TrajeAntiRayos;
import com.gusano.berserk.armas.AK47;
import com.gusano.berserk.armas.EspadaPesada;
import com.gusano.berserk.armas.SartenReflector;
import com.gusano.berserk.buffs.AlientoFuego;
import com.gusano.berserk.buffs.MunicionExtra;
import com.gusano.berserk.buffs.PocionVida;
import com.gusano.berserk.poderes.BotasTeletransporte;
import com.gusano.berserk.poderes.PantalonesFlotantes;
import com.gusano.berserk.poderes.RodillerasRebote;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class ServidorRPG {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            res.type("text/html");
            return htmlFormulario();
        });

        post("/pelear", (req, res) -> {
            res.type("text/html");

            Personaje worm = new GusanoBase();

            String armor = req.queryParams("armadura");
            String weapon = req.queryParams("arma");
            String power = req.queryParams("poder");
            String buff = req.queryParams("buff");

            worm = applyArmor(worm, armor);
            worm = applyWeapon(worm, weapon);
            worm = applyPower(worm, power);
            worm = applyBuff(worm, buff);

            String damageLog = worm.recibirDano(30);
            return htmlResultado(worm, armor, weapon, power, buff, damageLog);
        });
    }

    private static Personaje applyArmor(Personaje base, String option) {
        if ("casco".equals(option)) {
            return new CascoCaballero(base);
        }
        if ("capa".equals(option)) {
            return new CapaFuerza(base);
        }
        if ("traje".equals(option)) {
            return new TrajeAntiRayos(base);
        }
        return base;
    }

    private static Personaje applyWeapon(Personaje base, String option) {
        if ("espada-pesada".equals(option)) {
            return new EspadaPesada(base);
        }
        if ("ak47".equals(option)) {
            return new AK47(base);
        }
        if ("sarten-reflector".equals(option)) {
            return new SartenReflector(base);
        }
        return base;
    }

    private static Personaje applyPower(Personaje base, String option) {
        if ("pantalones".equals(option)) {
            return new PantalonesFlotantes(base);
        }
        if ("botas-teletransporte".equals(option)) {
            return new BotasTeletransporte(base);
        }
        if ("rodilleras".equals(option)) {
            return new RodillerasRebote(base);
        }
        return base;
    }

    private static Personaje applyBuff(Personaje base, String option) {
        if ("aliento-fuego".equals(option)) {
            return new AlientoFuego(base);
        }
        if ("municion-extra".equals(option)) {
            return new MunicionExtra(base);
        }
        if ("pocion-vida".equals(option)) {
            return new PocionVida(base);
        }
        return base;
    }

    private static String htmlFormulario() {
        return """
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <title>GusanoBerserk</title>
                <style>
                    body { font-family: monospace; background: #1a1a1a; color: #00ff00; margin: 0; }
                    .contenedor { max-width: 900px; margin: 30px auto; padding: 24px; border: 1px solid #00ff00; }
                    .grupo { margin: 16px 0; padding: 12px; border: 1px dashed #00ff00; }
                    select, button { font-family: monospace; background: #1a1a1a; color: #00ff00; border: 1px solid #00ff00; padding: 8px; }
                </style>
            </head>
            <body>
                <div class="contenedor">
                    <h1>Gusano Berserk // Ensamblador de 4 Capas</h1>
                    <form method="post" action="/pelear">
                        <div class="grupo">
                            <h3>[1] Armadura</h3>
                            <select name="armadura">
                                <option value="">Sin armadura</option>
                                <option value="casco">CascoCaballero</option>
                                <option value="capa">CapaFuerza</option>
                                <option value="traje">TrajeAntiRayos</option>
                            </select>
                        </div>
                        <div class="grupo">
                            <h3>[2] Arma</h3>
                            <select name="arma">
                                <option value="">Sin arma</option>
                                <option value="espada-pesada">EspadaPesada</option>
                                <option value="ak47">AK47</option>
                                <option value="sarten-reflector">SartenReflector</option>
                            </select>
                        </div>
                        <div class="grupo">
                            <h3>[3] Poder</h3>
                            <select name="poder">
                                <option value="">Sin poder</option>
                                <option value="pantalones">PantalonesFlotantes</option>
                                <option value="botas-teletransporte">BotasTeletransporte</option>
                                <option value="rodilleras">RodillerasRebote</option>
                            </select>
                        </div>
                        <div class="grupo">
                            <h3>[4] Buff</h3>
                            <select name="buff">
                                <option value="">Sin buff</option>
                                <option value="aliento-fuego">AlientoFuego</option>
                                <option value="municion-extra">MunicionExtra</option>
                                <option value="pocion-vida">PocionVida</option>
                            </select>
                        </div>
                        <button type="submit">Pelear</button>
                    </form>
                </div>
            </body>
            </html>
            """;
    }

    private static String htmlResultado(
        Personaje worm,
        String armor,
        String weapon,
        String power,
        String buff,
        String damageLog
    ) {
        return """
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <title>Resultado - GusanoBerserk</title>
                <style>
                    body { font-family: monospace; background: #000000; color: #00ff00; margin: 0; }
                    .contenedor { max-width: 900px; margin: 30px auto; padding: 24px; border: 1px solid #00ff00; }
                    ul { line-height: 1.8; }
                    a { color: #00ff00; }
                </style>
            </head>
            <body>
                <div class="contenedor">
                    <h1>Resultado del Ensamble</h1>
                    <p>Armadura: %s | Arma: %s | Poder: %s | Buff: %s</p>
                    <p>Descripcion: %s</p>
                    <pre style="font-family: monospace; background-color: #1a1a1a; color: #00ff00; padding: 20px;">%s</pre>
                    <ul>
                        <li>Vida: %d</li>
                        <li>Ataque: %d</li>
                        <li>Defensa: %d</li>
                        <li>Velocidad: %d</li>
                    </ul>
                    <p>Registro: %s</p>
                    <p><a href="/">Volver</a></p>
                </div>
            </body>
            </html>
            """.formatted(
                displayValue(armor),
                displayValue(weapon),
                displayValue(power),
                displayValue(buff),
                worm.getDescripcion(),
                worm.getSprite(),
                worm.getVida(),
                worm.getAtaque(),
                worm.getDefensa(),
                worm.getVelocidad(),
                damageLog
            );
    }

    private static String displayValue(String value) {
        return (value == null || value.isBlank()) ? "ninguno" : value;
    }
}

