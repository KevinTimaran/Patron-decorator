package com.gusano.berserk;

public final class SpriteBuilder {
    private SpriteBuilder() {
    }

    public static String fuse(String base, String layer) {
        String[] baseLines = base.split("\\R", -1);
        String[] layerLines = layer.split("\\R", -1);

        int height = Math.max(baseLines.length, layerLines.length);
        int width = maxWidth(baseLines, layerLines);
        StringBuilder merged = new StringBuilder();

        for (int y = 0; y < height; y++) {
            String baseLine = y < baseLines.length ? baseLines[y] : "";
            String layerLine = y < layerLines.length ? layerLines[y] : "";

            for (int x = 0; x < width; x++) {
                char basePixel = x < baseLine.length() ? baseLine.charAt(x) : ' ';
                char layerPixel = x < layerLine.length() ? layerLine.charAt(x) : ' ';
                // Keep the base body readable; draw layer mainly in empty zones.
                merged.append(layerPixel != ' ' && basePixel == ' ' ? layerPixel : basePixel);
            }

            if (y < height - 1) {
                merged.append('\n');
            }
        }

        return trimLeftAndRight(merged.toString());
    }

    public static String fusionar(String base, String accesorio) {
        return fuse(base, accesorio);
    }

    private static int maxWidth(String[] baseLines, String[] layerLines) {
        int width = 0;
        for (String line : baseLines) {
            width = Math.max(width, line.length());
        }
        for (String line : layerLines) {
            width = Math.max(width, line.length());
        }
        return width;
    }

    private static String trimLeftAndRight(String text) {
        String[] lines = text.split("\\n", -1);
        int minIndent = Integer.MAX_VALUE;

        for (String line : lines) {
            if (!line.isBlank()) {
                int indent = 0;
                while (indent < line.length() && line.charAt(indent) == ' ') {
                    indent++;
                }
                minIndent = Math.min(minIndent, indent);
            }
        }

        if (minIndent == Integer.MAX_VALUE) {
            minIndent = 0;
        }

        StringBuilder normalized = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String withoutLeft = line.length() >= minIndent ? line.substring(minIndent) : line;
            normalized.append(withoutLeft.replaceFirst("\\s+$", ""));
            if (i < lines.length - 1) {
                normalized.append('\n');
            }
        }

        return normalized.toString().replaceFirst("\\n+$", "");
    }
}

