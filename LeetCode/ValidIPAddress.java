/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

/**
 *
 * @author itspa
 */
public class ValidIPAddress {
    public String validIPAddress(String IP) {
        if(IP == null || IP.isEmpty()) return "Neither";
        ValidIPAddress obj = new ValidIPAddress();
        if(IP.contains(":")){
            return (isV6(IP)?"IPv6":"Neither");
        } else {
            return (isV4(IP)?"IPv4":"Neither");
        }
    }
     private boolean isV6(String ip){
        String gr[]= ip.split(":");
        int l = ip.length()-1;
        if(ip.charAt(l) == ':'){
            return false;
        }
        if(gr.length != 8) return false;
        for(String g:gr){
            if(g.isEmpty()) return false;
            if(g.length()> 4){
                return false;
            }
            for(int i = 0;i<g.length();i++){
                char ch = g.charAt(i);
                if(!((ch >= '0' && ch <= '9') || (ch>='a' && ch<='f') || (ch>='A' &&ch<='F'))) return false;
            }
        }
        return true;
    }
    
    private boolean isV4(String ip){
        String gr[] = ip.split("\\.");
        int l = ip.length()-1;
        if(ip.charAt(l) == '.'){
            return false;
        }
        if(gr.length != 4) return false;
        for(String g: gr){
            if(g.isEmpty()) return false;
            for(int i = 0;i<g.length();i++){
                char ch = g.charAt(i);
                if(ch < '0' || ch > '9') return false;
            }
            try { 
                int val = Integer.parseInt(g);
                if(val > 255 ) return false;
                if(g.charAt(0) == '0' && (val != 0 || g.length() != 1) ) return false;
            } catch(NumberFormatException e) { 
                return false; 
            } catch(NullPointerException e) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        ValidIPAddress obj = new ValidIPAddress();
        System.out.println(obj.validIPAddress("1.1.1.1."));
    }
}
