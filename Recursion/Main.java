public class Main {
    public static void printDec(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDec(n-1);
    }
    public static int fact(int n){
        if(n==0){
            return 1;
        }
        int fn=n*fact(n-1);
        return fn;
    }
    public static int calSum(int n){
        if(n==1){
            return 1;
        }
        return n+calSum(n-1);
    }
    public static int fibonnaci(int n){
        if(n==0 || n==1){
            return n;
        }
        int f1=fibonnaci(n-1);
        int f2=fibonnaci(n-2);
        return f1+f2;
    }
    public static boolean isSort(int[] arr,int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSort(arr,i+1);
    }
    public static void firstOcurr(int[] arr,int i,int k){
        if(arr.length==i){
            System.out.println("NOT");
            return ;
        }
        if(k==arr[i]){
            System.out.println(i);
            return;
        }
         firstOcurr(arr,i+1,3);

    }
    public static  int lastOcurr(int[] arr,int i,int k){
        if(i== arr.length){
            return -1;
        }
        int found=lastOcurr(arr,i+1,k);
        if(found==-1 && arr[i]==k){
            return i;
        }
        return found;
//        if(i==0){
//            System.out.println("NOT");
//            return;
//        }
//        if(arr[i]==k){
//            System.out.println(i);
//            return ;
//        }
//        lastOcurr(arr,i-1,3);

    }
    public static double power(double x,double n){
        if(n==0){
            return 1;
        }
        return x*power(x,n-1);
    }
    public static int OP(int x,int n){
        if(n==0)
            return 1;
        int halfP=OP(x,n/2);
        int psq=halfP*halfP;
        if(n%2!=0){
            psq=x*psq;
        }
        return psq;
    }
    public static int TillingProb(int n){
        if(n==0 || n==1){
            return 1;
        }
        int fnm1=TillingProb(n-1);
        int fnm2=TillingProb(n-2);
        return fnm1+fnm2;
    }
    public static void removeDup(String str,int i,StringBuilder newStr,boolean map[]){
        if(i==str.length()){
            System.out.println(newStr);
            return;
        }
        char ch=str.charAt(i);
        if(map[ch-'a']==true){
            removeDup(str,i+1,newStr,map);
        }else{
            map[ch-'a']=true;
            removeDup(str,i+1,newStr.append(ch),map);
        }

    }
    public static int PairFriends(int n){
        if(n==1 || n==2 ){
            return n;
        }
        int fpm1=PairFriends(n-1);
        int fpm2=PairFriends(n-2);
        int pairs=(n-1)*PairFriends(n-2);
        return fpm1+pairs;
    }
    public static void binaryStr(int n,int last,String bi){
        if(n==0){
            System.out.println(bi);
            return;
        }
        binaryStr(n-1,0,bi+"0");
        if(last==0){
            binaryStr(n-1,1,bi+"1");
        }
    }
    public static String digi[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void numtoString(int n){
        if(n==0){
            return;
        }
        int lastdigit=n%10;
        numtoString(n/10);
        System.out.print(digi[lastdigit]+" ");
    }
    public static int stirngS(String str){
        if(str.length()==0){
            return 0;
        }
        return stirngS(str.substring(1))+1;
    }
    public static void towerOfHanoi(int n,String src,String help,String des){
        if(n==1){
            System.out.println("tranfer disk"+n+"from"+src+"to"+des);
            return;
        }
        towerOfHanoi(n-1,src,des,help);
        System.out.println("tranfer disk"+n+"from"+src+"to"+des);
        towerOfHanoi(n-1,help,src,des);
    }
    public static void moveAllXToEnd(String str,int i,int count,StringBuilder newStr){
        if(str.length()==i){
            for (i=0;i<count;i++){
                newStr.append('x');
            }
            System.out.println(newStr);
            return;
        }
        char ch=str.charAt(i);
        if(ch=='x'){
            count++;
            moveAllXToEnd(str,i+1,count,newStr);
        }else {
            newStr.append(ch);
            moveAllXToEnd(str,i+1,count,newStr);
        }
    }
    public static void sub(String str,int i,String newStr){
        if(i==str.length()){
            System.out.println(newStr);
            return;
        }
        char ch=str.charAt(i);
        sub(str,i+1,newStr+ch);
        sub(str,i+1,newStr);
    }
    public static String[] keypad={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void combination(String str,int i,String combinations){
        if(i==str.length()){
            System.out.println(combinations);{
                return;
            }
        }
        char ch=str.charAt(i);
         String combi=keypad[ch-'0'];
        for(int j=0;j<combi.length();j++){
            combination(str,i+1,combinations+combi.charAt(j));
        }
    }
    public static void permutation(String str,String permu){
        if(str.length()==0){
            System.out.println(permu);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String newstr=str.substring(0,i)+str.substring(i+1);
            permutation(newstr,permu+ch);
        }
    }
    public static void main(String[] args) {
       String str="23";
       combination(str,0,"");
        }
    }
