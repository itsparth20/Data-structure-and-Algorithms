
public class ConvertStringToHTMLElement {

	public static void main(String[] args) {
		System.out.println(getElement("## data"));
		
	}

	/*
	 * Convert #### Data to <h4>Data</h4> #data -> #data ; because after # there
	 * should be space ####### sound-> ####### sound ; because <H7> is not a
	 * valid element ## path -> <h2>path</h2>
	 */
	public static String getElement(String markdown) {
		markdown = markdown.trim();
		if (markdown.charAt(0) == '#') {
			int count = 0;
			for (int i = 0; i < markdown.length(); i++) {
				if (i > 6) {
					return markdown;
				}
				if (markdown.charAt(i) != '#') {
					if (markdown.charAt(i) != ' ') {
						return markdown;
					}
					count = i;
					break;
				}
			}

			StringBuilder sb = new StringBuilder();
			appendValue(count, sb, false);
			String s = markdown.substring(count + 1).trim();
			sb.append(s);
			appendValue(count, sb, true);
			return sb.toString();
		}
		return markdown;

	}

	private static void appendValue(int count, StringBuilder sb, boolean sl) {
		if (sl)
			sb.append("</h");
		else
			sb.append("<h");
		sb.append(String.valueOf(count));
		sb.append(">");
	}
}
