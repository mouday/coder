public class Utils {
    public static String parseHeader(String text) {
        return parseString(text, "\n", ":");
    }

    public static String parseCookie(String text) {
        return parseString(text, ";", "=");
    }

    public static String parseString(String text, String lineDelimiter, String keyValueDelimiter) {
        if(text == null){return null;}
        if("".equals(text.trim())){return null;}

        String[] lines = text.split(lineDelimiter);

        StringBuilder buf =new StringBuilder();

        buf.append("{\n");

        for (int i = 0; i < lines.length; i++) {

            String[] key_value = lines[i].split(keyValueDelimiter, 2);

            String newLine = "  \"" + key_value[0].trim() + "\": " + "\"" + key_value[1].trim() + "\"";
            if (i + 1 != lines.length) {
                newLine += ",\n";
            } else {
                newLine += "\n";
            }
            buf.append(newLine);
        }

        buf.append("}\n");
        return buf.toString();
    }

    public static void main(String[] args) {

        System.out.println(Utils.parseHeader("Accept-Encoding: gzip, : deflate, br\n" +
                "Accept-Language: zh-CN,zh;q=0.9,en;q=0.8\n" +
                "Cache-Control: no-cache\n" +
                "Connection: keep-alive"));
        // System.out.println("dsd:sadfas\r\ndsd:sadfas".split("\r\n"));
    }
}

