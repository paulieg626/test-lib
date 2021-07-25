package mmc.lib;

public class Launges{
	//Regex - Регекс
	public static String JavaScript = "\\b(Vars|Fx|let|require|abstract|boolean|break|byte|case|catch|char|class|const|continue|debugger|default|delete|do|double|else|enum|export|extends|false|final|finally|float|for|function|goto|if|implements|import|in|instanceof|int|interface|long|native|new|null|package|private|protected|public|return|short|static|super|switch|synchronized|this|throw|throws|transient|true|try|typeof|var|void|volatile|while|with)\\b";
	public static String Hjson = "\\b(true|false)\\b";
	public static String Json = "\\b(true|false)\\b";
	public static String Quote = "\"((\\\\.|[^\\\\\"])*)\"";
	public static String Number = "(\\b(\\d*[.]?\\d+)\\b)";
	public static String Color = "([\"][#]([0-9]|[a-f]|[A-F]){6}[\"]|\\[[#](([0-9]|[a-f]|[A-F]){6})\\])";
	public static String Bracket = "(\\(|\\[|\\{|\\)|\\]|\\})";
    public static String Bracket1 = "(\\(|\\[|\\{)"; // (
    public static String Bracket2 = "(\\)|\\]|\\})"; // )
    public static String Comment = "(/\\*(?:.|[\\n\\r])*?\\*/|(?m)//(.+?)(?=//|$))";
	
    public static int findClosingBracket(String str,String b,int level) {
        if (str.indexOf(b.charAt(1)) == -1) {
            return -1;
        }

        int l = str.length();
        
        for (int i = 0;i < l; i++) {
            if (Character.toString(str.charAt(i)).equals('\\')) {
                i++;
            } else if (str.charAt(i) == b.charAt(0)) {
                level++;
            } else if (str.charAt(i) == b.charAt(1)) {
                level--;

                if (level < 0) {
                    return i;
                }
            }
        }

        return -1;
    }
    
    public static int findOpenBracket(String str,String b,int level) {
        if (str.indexOf(b.charAt(0)) == -1) {
            return -1;
        }
        
        int l = str.length();
        int p = 0;
        for (int i = l-1;i >= 0; i--) {
            p++;
            if (Character.toString(str.charAt(i)).equals('\\')) {
                p++;
                i--;
            } else if (str.charAt(i) == b.charAt(1)) {
                level++;
            } else if (str.charAt(i) == b.charAt(0)) {
                level--;

                if (level < 0) {
                    return p;
                }
            }
        }

        return -1;
    }
}
