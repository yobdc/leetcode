package yobdc;

public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
		if(strs.length()==0){
			return null;
		}
		if(strs.length()==1){
			return strs[0];
		}
		String tar = strs[0];
		StringBuffer sb = new StringBuffer();
		int index = 0;
		while(index<tar.length()){
			for(int i=1;i<strs.length();i++){
				if(tar.charAt(index)!=str[i].charAt(index)){
					return sb.toString()
				}
			}
			sb.append(tar.charAt(index));
		}
		return sb.toString();
    }

    public void test() {
        String[] strs = {"aaa", "aab"};
        System.out.println(longestCommonPrefix(strs));
    }
}
