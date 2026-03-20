package com.gusano.berserk;

public final class SpriteBuilder {
    private SpriteBuilder() {
    }

    public static String fusionar(String base, String accesorio) {
        String[] baseLineas = base.split("\\R", -1);
        String[] capaLineas = accesorio.split("\\R", -1);

        int alto = Math.max(baseLineas.length, capaLineas.length);
        int ancho = calcularAnchoMaximo(baseLineas, capaLineas);
        StringBuilder resultado = new StringBuilder();

        for (int y = 0; y < alto; y++) {
            String baseLinea = y < baseLineas.length ? baseLineas[y] : "";
            String capaLinea = y < capaLineas.length ? capaLineas[y] : "";

            for (int x = 0; x < ancho; x++) {
                char pixelBase = x < baseLinea.length() ? baseLinea.charAt(x) : ' ';
                char pixelCapa = x < capaLinea.length() ? capaLinea.charAt(x) : ' ';
                resultado.append(pixelCapa != ' ' ? pixelCapa : pixelBase);
            }

            if (y < alto - 1) {
                resultado.append('\n');
            }
        }

        return recortarDerecha(resultado.toString());
    }

    public static String superponer(String base, String capa) {
        return fusionar(base, capa);
    }

    private static int calcularAnchoMaximo(String[] baseLineas, String[] capaLineas) {
        int ancho = 0;
        for (String linea : baseLineas) {
            ancho = Math.max(ancho, linea.length());
        }
        for (String linea : capaLineas) {
            ancho = Math.max(ancho, linea.length());
        }
        return ancho;
    }

    private static String recortarDerecha(String texto) {
        String[] lineas = texto.split("\\n", -1);
        StringBuilder normalizado = new StringBuilder();

        for (int i = 0; i < lineas.length; i++) {
            normalizado.append(lineas[i].replaceFirst("\\s+$", ""));
            if (i < lineas.length - 1) {
                normalizado.append('\n');
            }
        }

        return normalizado.toString();
    }
}

