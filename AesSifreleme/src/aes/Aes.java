package aes;

/**
 *
 * @author Nurrettin
 */

public class Aes {
  
    public static String[][] roundkey    =new String[4][44];
    
    public static String [][]Rcon={
        {"01","02","04","08","10","20","40","80","1b","36"},
        {"00","00","00","00","00","00","00","00","00","00"},
        {"00","00","00","00","00","00","00","00","00","00"},
        {"00","00","00","00","00","00","00","00","00","00"}
    };
    
    public static String [][]SBOX={
        {"63","7c","77","7b","f2","6b","6f","c5","30","01","67","2b","fe","d7","ab","76"},
        {"ca","82","c9","7d","fa","59","47","f0","ad","d4","a2","af","9c","a4","72","c0"},
        {"b7","fd","93","26","36","3f","f7","cc","34","a5","e5","f1","71","d8","31","15"},
        {"04","c7","23","c3","18","96","05","9a","07","12","80","e2","eb","27","b2","75"},
        {"09","83","2c","1a","1b","6e","5a","a0","52","3b","d6","b3","29","e3","2f","84"},
        {"53","d1","00","ed","20","fc","b1","5b","6a","cb","be","39","4a","4c","58","cf"},
        {"d0","ef","aa","fb","43","4d","33","85","45","f9","02","7f","50","3c","9f","a8"},
        {"51","a3","40","8f","92","9d","38","f5","bc","b6","da","21","10","ff","f3","d2"},
        {"cd","0c","13","ec","5f","97","44","17","c4","a7","7e","3d","64","5d","19","73"},
        {"60","81","4f","dc","22","2a","90","88","46","ee","b8","14","de","5e","0b","db"},
        {"e0","32","3a","0a","49","06","24","5c","c2","d3","ac","62","91","95","e4","79"},
        {"e7","c8","37","6d","8d","d5","4e","a9","6c","56","f4","ea","65","7a","ae","08"},
        {"ba","78","25","2e","1c","a6","b4","c6","e8","dd","74","1f","4b","bd","8b","8a"},
        {"70","3e","b5","66","48","03","f6","0e","61","35","57","b9","86","c1","1d","9e"},
        {"e1","f8","98","11","69","d9","8e","94","9b","1e","87","e9","ce","55","28","df"},
        {"8c","a1","89","0d","bf","e6","42","68","41","99","2d","0f","b0","54","bb","16"},
                                        };
    public  static String[][] SiBOX = { 
        {"52","09","6a","d5","30","36","a5","38","bf","40","a3","9e","81","f3","d7","fb"},
        {"7c","e3","39","82","9b","2f","ff","87","34","8e","43","44","c4","de","e9","cb"},
        {"54","7b","94","32","a6","c2","23","3d","ee","4c","95","0b","42","fa","c3","4e"},
        {"08","2e","a1","66","28","d9","24","b2","76","5b","a2","49","6d","8b","d1","25"},
        {"72","f8","f6","64","86","68","98","16","d4","a4","5c","cc","5d","65","b6","92"}, 
        {"6c","70","48","50","fd","ed","b9","da","5e","15","46","57","a7","8d","9d","84"},
        {"90","d8","ab","00","8c","bc","d3","0a","f7","e4","58","05","b8","b3","45","06"},
        {"d0","2c","1e","8f","ca","3f","0f","02","c1","af","bd","03","01","13","8a","6b"},
        {"3a","91","11","41","4f","67","dc","ea","97","f2","cf","ce","f0","b4","e6","73"},
        {"96","ac","74","22","e7","ad","35","85","e2","f9","37","e8","1c","75","df","6e"}, 
        {"47","f1","1a","71","1d","29","c5","89","6f","b7","62","0e","aa","18","be","1b"},
        {"fc","56","3e","4b","c6","d2","79","20","9a","db","c0","fe","78","cd","5a","f4"},
        {"1f","dd","a8","33","88","07","c7","31","b1","12","10","59","27","80","ec","5f"},
        {"60","51","7f","a9","19","b5","4a","0d","2d","e5","7a","9f","93","c9","9c","ef"},
        {"a0","e0","3b","4d","ae","2a","f5","b0","c8","eb","bb","3c","83","53","99","61"}, 
        {"17","2b","04","7e","ba","77","d6","26","e1","69","14","63","55","21","0c","7d"}
                                        }; 
 
    public static byte        GMul(int a, int b) { // Galois Field (256) Multiplication of two Bytes

   byte p = 0;
   byte counter;
   byte hi_bit_set;
   for (counter = 0; counter < 8; counter++) {
      if ((b & 1) != 0) {
         p ^= a;
      }
      hi_bit_set = (byte) (a & 0x80);
      a <<= 1;
      if (hi_bit_set != 0) {
         a ^= 0x1b; /* x^8 + x^4 + x^3 + x + 1 */
      }
      b >>= 1;
   }
   return p;
}
   
    public static int         HexToDec(String enterr){
            int exit=0;
            
            if(enterr.equals("0")){
            exit=0;
            }else if(enterr.equals("1")){
            exit=1;    
            }else if(enterr.equals("2")){
            exit=2;    
            }else if(enterr.equals("3")){
            exit=3;    
            }else if(enterr.equals("4")){
            exit=4;    
            }else if(enterr.equals("5")){
            exit=5;    
            }else if(enterr.equals("6")){
            exit=6;    
            }else if(enterr.equals("7")){
            exit=7;    
            }else if(enterr.equals("8")){
            exit=8;    
            }else if(enterr.equals("9")){
            exit=9;    
            }else if(enterr.equals("a")){
            exit=10;    
            }else if(enterr.equals("b")){
            exit=11;    
            }else if(enterr.equals("c")){
            exit=12;    
            }else if(enterr.equals("d")){
            exit=13;    
            }else if(enterr.equals("e")){
            exit=14;    
            }else if(enterr.equals("f")){
            exit=15;    
            }
        return exit;
    }  
    
    public static void        KeySchedule(String key[][]){
                
                for(int i=0;i<4;i++) 
                for(int j=0;j<4;j++) 
                        roundkey[i][j] = key[i][j];
                
              String temp=null;
              int round=0;
              String rot[][]=new String[4][1];
              
              for (int i = 4; i < 44; i++) {
                  if(i%4==0){
                for (int k = 0; k < 4; k++) {
                      rot[k][0]=roundkey[k][i-1];
                  }  
                  rot=RotWord(rot);
                  rot=SubBytes(rot);
                  
              for (int j = 0; j < 4; j++) {
                temp=Integer.toHexString( (Integer.parseInt(rot[j][0],16)^Integer.parseInt(roundkey[j][i-4],16)^Integer.parseInt(Rcon[j][round],16)) & 0xFF);
                if(temp.length()==1){temp="0"+temp;}
                roundkey[j][i]=temp;
                }
              
                round++;
                }else{
                  for (int k = 0; k < 4; k++) {
                      rot[k][0]=roundkey[k][i-1];
                  } 
                  
                  for (int j = 0; j < 4; j++) {
                temp=Integer.toHexString( (Integer.parseInt(rot[j][0],16)^Integer.parseInt(roundkey[j][i-4],16)) & 0xFF);
                if(temp.length()==1){temp="0"+temp;}
                roundkey[j][i]=temp;
                }
                  
                  }
              
         }
    
    }
    
    
    
    public static String [][] MixColumnss(String s[][]) { // 's' is the main State matrix, 'ss' is a temp matrix of the same dimensions as 's'.
   String [][] ss=new String[4][4];
   for (int c = 0; c < 4; c++) {
       
      ss[0][c] =Integer.toHexString( (byte) (GMul(0x02,Integer.parseInt(s[0][c], 16)) ^ GMul(0x03, Integer.parseInt(s[1][c], 16)) ^ Integer.parseInt(s[2][c], 16) ^ Integer.parseInt(s[3][c], 16)) & 0xFF);
      ss[1][c] =Integer.toHexString( (byte) (Integer.parseInt(s[0][c], 16) ^ GMul(0x02, Integer.parseInt(s[1][c], 16)) ^ GMul(0x03, Integer.parseInt(s[2][c], 16)) ^ Integer.parseInt(s[3][c], 16)) & 0xFF);
      ss[2][c] =Integer.toHexString( (byte) (Integer.parseInt(s[0][c], 16) ^ Integer.parseInt(s[1][c], 16) ^ GMul(0x02, Integer.parseInt(s[2][c], 16)) ^ GMul(0x03, Integer.parseInt(s[3][c], 16))) & 0xFF);
      ss[3][c] =Integer.toHexString( (byte) (GMul(0x03, Integer.parseInt(s[0][c], 16)) ^ Integer.parseInt(s[1][c], 16) ^ Integer.parseInt(s[2][c], 16) ^ GMul(0x02, Integer.parseInt(s[3][c], 16))) & 0xFF);
   }
return ss;
}
    
    public static String [][] inMixColumnss(String s[][]) { // 's' is the main State matrix, 'ss' is a temp matrix of the same dimensions as 's'.
   String [][] ss=new String[4][4];
   for (int c = 0; c < 4; c++) {
       
      ss[0][c] =Integer.toHexString( (byte) (GMul(0x0E,Integer.parseInt(s[0][c], 16)) ^ GMul(0x0B, Integer.parseInt(s[1][c], 16)) ^ GMul(0x0D, Integer.parseInt(s[2][c], 16)) ^ GMul(0x09, Integer.parseInt(s[3][c], 16))) & 0xFF);
      ss[1][c] =Integer.toHexString( (byte) (GMul(0x09,Integer.parseInt(s[0][c], 16)) ^ GMul(0x0E, Integer.parseInt(s[1][c], 16)) ^ GMul(0x0B, Integer.parseInt(s[2][c], 16)) ^ GMul(0x0D, Integer.parseInt(s[3][c], 16))) & 0xFF);
      ss[2][c] =Integer.toHexString( (byte) (GMul(0x0D,Integer.parseInt(s[0][c], 16)) ^ GMul(0x09, Integer.parseInt(s[1][c], 16)) ^ GMul(0x0E, Integer.parseInt(s[2][c], 16)) ^ GMul(0x0B, Integer.parseInt(s[3][c], 16))) & 0xFF);
      ss[3][c] =Integer.toHexString( (byte) (GMul(0x0B,Integer.parseInt(s[0][c], 16)) ^ GMul(0x0D, Integer.parseInt(s[1][c], 16)) ^ GMul(0x09, Integer.parseInt(s[2][c], 16)) ^ GMul(0x0E, Integer.parseInt(s[3][c], 16))) & 0xFF);
   }
return ss;
}
      
    public static String [][] AddRoundKey(String dizi[][],String cipherkey[][]){
        String temp=null;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp=Integer.toHexString(Integer.parseInt(dizi[j][i],16)^Integer.parseInt(cipherkey[j][i],16) & 0xFF);
                if(temp.length()==1){temp="0"+temp;}
                dizi[j][i]=temp;
            }
        }
        return dizi;
    }
    
    public static String [][] SubBytes (String dizi[][]){
    
        String temp=null;
        int satir=0,sutun=0;
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                temp=dizi[i][j];
                satir=HexToDec(temp.charAt(0)+"");
                sutun=HexToDec(temp.charAt(1)+"");
                dizi[i][j]=SBOX[satir][sutun];
            }
    
        }
        return dizi;
    }
    
    public static String [][] inSubBytes (String dizi[][]){
    
        String temp=null;
        int satir=0,sutun=0;
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                temp=dizi[i][j];
                if(temp.length()==1){temp="0"+temp;}
                satir=HexToDec(temp.charAt(0)+"");
                sutun=HexToDec(temp.charAt(1)+"");
                dizi[i][j]=SiBOX[satir][sutun];
            }
    
        }
        return dizi;
    }
    
    public static String [][] ShiftRows(String dizi[][]){
        String temp=null;
        for (int i = 1; i <4; i++) {
            for (int j = 0; j < i; j++) {
                    temp=dizi[i][0];
                    dizi[i][0]=dizi[i][1];
                    dizi[i][1]=dizi[i][2];
                    dizi[i][2]=dizi[i][3];
                    dizi[i][3]=temp;
            }
        }
        return dizi;
    }
    
    public static String [][] inShiftRows(String dizi[][]){
        String temp=null;
        for (int i = 1; i <4; i++) {
            for (int j = 0; j < i; j++) {
                    temp=dizi[i][3];
                    dizi[i][3]=dizi[i][2];
                    dizi[i][2]=dizi[i][1];
                    dizi[i][1]=dizi[i][0];
                    dizi[i][0]=temp;
            }
        }
        return dizi;
    }
    
    public static String [][] Encryption(String state[][],String cipherkey[][]){
    //------------------------------------------------Start Encryption
         KeySchedule(cipherkey);
         state=AddRoundKey(state, cipherkey);
 //----------------------------------------------- İnitial Round
         
         for (int i = 1; i < 10; i++) {
            state=SubBytes(state);
            state=ShiftRows(state);
            state=MixColumnss(state);
            state=AddRoundKey(state, GetRoundKey(i));
        }
//--------------------------------------------------- 9 Round looping 
         
         state=SubBytes(state);
         state=ShiftRows(state);
         state=AddRoundKey(state, GetRoundKey(10));
         
//----------------------------------------------------- Final round
         return state;
    }
    
    public static String [][] Decryption(String state[][],String cipherkey[][]){
    
    //-------------------------------------------------------Start Decryption
           KeySchedule(cipherkey);
           state=AddRoundKey(state,GetRoundKey(10));
           state=inShiftRows(state);
           state=inSubBytes(state);
           
 //--------------------------------------------------------
           for (int i = 9; i > 0; i--) {
            state=AddRoundKey(state, GetRoundKey(i));
            state=inMixColumnss(state);
            state=inShiftRows(state);
            state=inSubBytes(state);
            
        }
           state=AddRoundKey(state, cipherkey);
           
           return state;
    }
         
    public static String [][] RotWord(String dizi[][]){
                    String temp=null;
                    temp=dizi[0][0];
                    dizi[0][0]=dizi[1][0];
                    dizi[1][0]=dizi[2][0];
                    dizi[2][0]=dizi[3][0];
                    dizi[3][0]=temp;
            return dizi;
    }
    
    public static String [][] GetRoundKey(int round){
    String roundkeyReturn[][]=new String[4][4];
    
       int a=0,b=0;
        for (int i = 0; i < 4; i++) {
            for (int j = round*4; j < (round*4)+4; j++) {
                roundkeyReturn[a][b]=roundkey[i][j];
                b++;
            }
            a++;
            b=0;
        }
        return roundkeyReturn;
        
    }
    
    
    public static void main(String[] args) {

//         String[][] state={
//            {"32","88","31","e0"},
//            {"43","5a","31","37"},
//            {"f6","30","98","07"},
//            {"a8","8d","a2","34"}
//        };
//         
//         String[][] cipherkey={
//            {"2b","28","ab","09"},
//            {"7e","ae","f7","cf"},
//            {"15","d2","15","4f"},
//            {"16","a6","88","3c"}
//        };
//
//         
//
//         
//         state=Encryption(state, cipherkey);
//           for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(state[i][j]+" ");
//            }
//            System.out.println(" ");
//        }      
//         
// 
//           System.out.println("--------------------------------------");
//           state=Decryption(state, cipherkey);
//           for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(state[i][j]+" ");
//            }
//            System.out.println(" ");
//        }
           
 //---------------------------------------------------------------------------------------------------------------------------------          
       
//        String subBytesTest[][]={
//            {"04","e0","48","28"},
//            {"66","cb","f8","06"},
//            {"81","19","d3","26"},
//            {"e5","9a","7a","4c"}
//        };
//            
//        subBytesTest=inMixColumnss(subBytesTest);
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(subBytesTest[i][j]+" ");
//            }
//            System.out.println(" ");
//        }
        
//      byte b = 127;
//      System.out.println(Integer.toHexString(75 & 0xFF));
     System.out.println(Integer.parseInt("1e", 16));

        char a='ǚ';
System.out.println((byte)a);


    }
    
}
