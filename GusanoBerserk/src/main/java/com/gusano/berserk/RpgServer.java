package com.gusano.berserk;

import com.gusano.berserk.armors.ForceCape;
import com.gusano.berserk.armors.KnightHelmet;
import com.gusano.berserk.armors.LightningSuit;
import com.gusano.berserk.buffs.ExtraAmmo;
import com.gusano.berserk.buffs.FireBreath;
import com.gusano.berserk.buffs.HealthPotion;
import com.gusano.berserk.powers.FloatingPants;
import com.gusano.berserk.powers.ReboundKneePads;
import com.gusano.berserk.powers.TeleportBoots;
import com.gusano.berserk.weapons.Ak47;
import com.gusano.berserk.weapons.HeavySword;
import com.gusano.berserk.weapons.ReflectorPan;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class RpgServer {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            res.type("text/html");
            return buildFormHtml();
        });

        post("/pelear", (req, res) -> {
            res.type("text/html");

            Character worm = new WormBase();

            String armorOption = req.queryParams("armadura");
            String weaponOption = req.queryParams("arma");
            String powerOption = req.queryParams("poder");
            String buffOption = req.queryParams("buff");

            worm = applyArmor(worm, armorOption);
            worm = applyWeapon(worm, weaponOption);
            worm = applyPower(worm, powerOption);
            worm = applyBuff(worm, buffOption);

            String damageLog = worm.receiveDamage(30);
            return buildResultHtml(worm, armorOption, weaponOption, powerOption, buffOption, damageLog);
        });
    }

    private static Character applyArmor(Character base, String option) {
        if ("casco".equals(option)) {
            return new KnightHelmet(base);
        }
        if ("capa".equals(option)) {
            return new ForceCape(base);
        }
        if ("traje".equals(option)) {
            return new LightningSuit(base);
        }
        return base;
    }

    private static Character applyWeapon(Character base, String option) {
        if ("espada-pesada".equals(option)) {
            return new HeavySword(base);
        }
        if ("ak47".equals(option)) {
            return new Ak47(base);
        }
        if ("sarten-reflector".equals(option)) {
            return new ReflectorPan(base);
        }
        return base;
    }

    private static Character applyPower(Character base, String option) {
        if ("pantalones".equals(option)) {
            return new FloatingPants(base);
        }
        if ("botas-teletransporte".equals(option)) {
            return new TeleportBoots(base);
        }
        if ("rodilleras".equals(option)) {
            return new ReboundKneePads(base);
        }
        return base;
    }

    private static Character applyBuff(Character base, String option) {
        if ("aliento-fuego".equals(option)) {
            return new FireBreath(base);
        }
        if ("municion-extra".equals(option)) {
            return new ExtraAmmo(base);
        }
        if ("pocion-vida".equals(option)) {
            return new HealthPotion(base);
        }
        return base;
    }

    private static String buildFormHtml() {
        return """
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <title>GusanoBerserk</title>
                <style>
                    body { font-family: monospace; background: #1a1a1a; color: #00ff66; margin: 0; }
                    .container { max-width: 950px; margin: 24px auto; padding: 20px; border: 1px solid #00ff66; }
                    .group { margin: 14px 0; padding: 12px; border: 1px dashed #00ff66; }
                    select, button { font-family: monospace; background: #1a1a1a; color: #00ff66; border: 1px solid #00ff66; padding: 8px; }
                    button { margin-top: 10px; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>Gusano Berserk // Ensamblador</h1>
                    <form method="post" action="/pelear">
                        <div class="group">
                            <h3>[1] Armadura</h3>
                            <select name="armadura">
                                <option value="">Sin armadura</option>
                                <option value="casco">Casco de Caballero</option>
                                <option value="capa">Capa de Fuerza</option>
                                <option value="traje">Traje AntiRayos</option>
                            </select>
                        </div>
                        <div class="group">
                            <h3>[2] Arma</h3>
                            <select name="arma">
                                <option value="">Sin arma</option>
                                <option value="espada-pesada">Espada Pesada</option>
                                <option value="ak47">AK47</option>
                                <option value="sarten-reflector">Sarten Reflector</option>
                            </select>
                        </div>
                        <div class="group">
                            <h3>[3] Poder</h3>
                            <select name="poder">
                                <option value="">Sin poder</option>
                                <option value="pantalones">Pantalones Flotantes</option>
                                <option value="botas-teletransporte">Botas de Teletransporte</option>
                                <option value="rodilleras">Rodilleras de Rebote</option>
                            </select>
                        </div>
                        <div class="group">
                            <h3>[4] Buff</h3>
                            <select name="buff">
                                <option value="">Sin buff</option>
                                <option value="aliento-fuego">Aliento de Fuego</option>
                                <option value="municion-extra">Municion Extra</option>
                                <option value="pocion-vida">Pocion de Vida</option>
                            </select>
                        </div>
                        <button type="submit">Pelear</button>
                    </form>
                </div>
            </body>
            </html>
            """;
    }

    private static String buildResultHtml(
        Character worm,
        String armorOption,
        String weaponOption,
        String powerOption,
        String buffOption,
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
                    body { font-family: monospace; background: #000; color: #00ff00; margin: 0; }
                    .container { max-width: 1100px; margin: 24px auto; padding: 20px; border: 1px solid #00ff00; }
                    .sprite-box { background: #0c0c0c; border: 1px solid #1f9f1f; padding: 16px; overflow-x: auto; }
                    pre { margin: 0; font-family: "Courier New", monospace; line-height: 1.1; white-space: pre; }
                    ul { line-height: 1.7; }
                    a { color: #00ff00; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>Resultado del Ensamble</h1>
                    <p>Armadura: %s | Arma: %s | Poder: %s | Buff: %s</p>
                    <p>Descripcion: %s</p>
                    <div class="sprite-box"><pre>%s</pre></div>
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
            showOption(armorOption),
            showOption(weaponOption),
            showOption(powerOption),
            showOption(buffOption),
            worm.getDescription(),
            escapeHtml(worm.getSprite()),
            worm.getHealth(),
            worm.getAttack(),
            worm.getDefense(),
            worm.getSpeed(),
            damageLog
        );
    }

    private static String showOption(String value) {
        return value == null || value.isBlank() ? "ninguno" : value;
    }

    private static String escapeHtml(String raw) {
        return raw
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;");
    }
}

