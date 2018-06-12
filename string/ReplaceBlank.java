/**
* 问题描述：请实现一个函数，将一个字符串中的空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
* 解题思路：新建一个字符串，逐个字符的比较，当是空字符的时候，增加%20，不然复制原来的字符
* 时间复杂度是O(n)
*/
public class Solution {
    public String replaceSpace(StringBuffer str){
        if(str == null){
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String string = str.toString();
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == ' '){
                stringBuffer.append("%20");
            }else{
                stringBuffer.append(string.charAt(i));
            }
        }
        String s = stringBuffer.toString();
        return s;
    }
}