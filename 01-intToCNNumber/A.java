public class A
{
    /**
     * 千万以内int型数字转换为中文汉字
     *
     * @param num 待转换int
     * @return 转换后的中文汉字
     */
    public static String intToCNNumber(int num)
        {
            String[] s = {"十", "百", "千", "万"};
            String[] s1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
            StringBuffer plainCNNum = new StringBuffer();
            while(num > 0)
            {
                plainCNNum.append(s1[num % 10]);
                num = num / 10;
            }
            int len = plainCNNum.length();
            for(int i = (len > 8 ? 8 : len) - 1; i > 0 ; i--)
            {
                plainCNNum.insert(i, s[(i - 1) % 4]);
            }
            String result = plainCNNum.reverse().toString();
            result = result.replaceAll("零", "");
            result = result.replaceAll("百十", "百零");
            result = result.replaceAll("千百", "千零");
            result = result.replaceAll("万千", "万零");
            result = result.replaceAll("零零", "零");
            result = result.replaceAll("零零", "零");
            result = result.replaceAll("零百", "百");
            result = result.replaceAll("零千", "千");
            result = result.replaceAll("零万", "万");
            if (result.endsWith("零")) {
                result = result.substring(0, result.length() -1 );
            }
            if (result.startsWith("一十")) {
                result = result.substring(1);
            }
            if (result.length() == 0) {
                result = "零";
            }
            return result;
        }

}
