/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author UX305
 */
public class Rule {

    public static int MAX_SL_NGUYEN_AM = 3;
    public static int MIN_SL_NGUYEN_AM = 1;
    
    public static int MAX_SL_PHU_AM = 5;
    public static int MIN_SL_PHU_AM = 0;
    
    int id = 0;
   
    
    //public final char[] phuAmCuoi = {'C', 'c', 'G', 'g', 'H', 'h', 'M', 'm', 'N', 'n', 'P', 'p', 'T', 't'};
    public final char[] notPhuAmCuoi = {'B', 'b', 'D', 'd', 'Đ', 'đ', 'K', 'k', 'L', 'l', 'Q', 'q', 'R', 'r', 'S', 's', 'V', 'v', 'X', 'x'};
    public final char[] nguyenAm = {
        'A', 'À', 'Á', 'Ả', 'Ã', 'Ạ',
        'Ă', 'Ằ', 'Ắ', 'Ẳ', 'Ẵ', 'Ặ',
        'Â', 'Ầ', 'Ấ', 'Ẩ', 'Ẫ', 'Ậ',
        'E', 'È', 'É', 'Ẻ', 'Ẽ', 'Ẹ',
        'Ê', 'Ề', 'Ế', 'Ể', 'Ễ', 'Ệ',
        'I', 'Ì', 'Í', 'Ỉ', 'Ĩ', 'Ị',
        'O', 'Ò', 'Ó', 'Ỏ', 'Õ', 'Ọ',
        'Ô', 'Ồ', 'Ố', 'Ổ', 'Ỗ', 'Ộ',
        'Ơ', 'Ờ', 'Ớ', 'Ở', 'Ỡ', 'Ợ',
        'U', 'Ù', 'Ú', 'Ủ', 'Ũ', 'Ụ',
        'Ư', 'Ừ', 'Ứ', 'Ử', 'Ữ', 'Ự',
        'Y', 'Ỳ', 'Ý', 'Ỷ', 'Ỹ', 'Ỵ',
        'a', 'à', 'á', 'ả', 'ã', 'ạ',
        'ă', 'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ',
        'â', 'ầ', 'ấ', 'ẩ', 'ẫ', 'ậ',
        'e', 'è', 'é', 'ẻ', 'ẽ', 'ẹ',
        'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ',
        'i', 'ì', 'í', 'ỉ', 'ĩ', 'ị',
        'o', 'ò', 'ó', 'ỏ', 'õ', 'ọ',
        'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ',
        'ơ', 'ờ', 'ớ', 'ở', 'ỡ', 'ợ',
        'u', 'ù', 'ú', 'ủ', 'ũ', 'ụ',
        'ư', 'ừ', 'ứ', 'ử', 'ữ', 'ự',
        'y', 'ỳ', 'ý', 'ỷ', 'ỹ', 'ỵ',
    };
    public final char[] nguyenAmThanh = {
	
        'À', 'Á', 'Ả', 'Ã', 'Ạ',
        'Ằ', 'Ắ', 'Ẳ', 'Ẵ', 'Ặ',
        'Ầ', 'Ấ', 'Ẩ', 'Ẫ', 'Ậ',
        'È', 'É', 'Ẻ', 'Ẽ', 'Ẹ',
        'Ề', 'Ế', 'Ể', 'Ễ', 'Ệ',
        'Ì', 'Í', 'Ỉ', 'Ĩ', 'Ị',
        'Ò', 'Ó', 'Ỏ', 'Õ', 'Ọ',
        'Ồ', 'Ố', 'Ổ', 'Ỗ', 'Ộ',
        'Ờ', 'Ớ', 'Ở', 'Ỡ', 'Ợ',
        'Ù', 'Ú', 'Ủ', 'Ũ', 'Ụ',
        'Ừ', 'Ứ', 'Ử', 'Ữ', 'Ự',
        'Ỳ', 'Ý', 'Ỷ', 'Ỹ', 'Ỵ',
        'à', 'á', 'ả', 'ã', 'ạ',
        'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ',
        'ầ', 'ấ', 'ẩ', 'ẫ', 'ậ',
        'è', 'é', 'ẻ', 'ẽ', 'ẹ',
        'ề', 'ế', 'ể', 'ễ', 'ệ',
        'ì', 'í', 'ỉ', 'ĩ', 'ị',
        'ò', 'ó', 'ỏ', 'õ', 'ọ',
        'ồ', 'ố', 'ổ', 'ỗ', 'ộ',
        'ờ', 'ớ', 'ở', 'ỡ', 'ợ',
        'ù', 'ú', 'ủ', 'ũ', 'ụ',
        'ừ', 'ứ', 'ử', 'ữ', 'ự',
        'ỳ', 'ý', 'ỷ', 'ỹ', 'ỵ',

	};
    public final char[] upperCase = {
	'A', 'À', 'Á', 'Ả', 'Ã', 'Ạ',
	'Ă', 'Ằ', 'Ắ', 'Ẳ', 'Ẵ', 'Ặ',
	'Â', 'Ầ', 'Ấ', 'Ẩ', 'Ẫ', 'Ậ',
	'E', 'È', 'É', 'Ẻ', 'Ẽ', 'Ẹ',
	'Ê', 'Ề', 'Ế', 'Ể', 'Ễ', 'Ệ',
	'I', 'Ì', 'Í', 'Ỉ', 'Ĩ', 'Ị',
	'O', 'Ò', 'Ó', 'Ỏ', 'Õ', 'Ọ',
	'Ô', 'Ồ', 'Ố', 'Ổ', 'Ỗ', 'Ộ',
	'Ơ', 'Ờ', 'Ớ', 'Ở', 'Ỡ', 'Ợ',
	'U', 'Ù', 'Ú', 'Ủ', 'Ũ', 'Ụ',
	'Ư', 'Ừ', 'Ứ', 'Ử', 'Ữ', 'Ự',
	'Y', 'Ỳ', 'Ý', 'Ỷ', 'Ỹ', 'Ỵ',
	'B', 'C', 'D', 'Đ', 'G', 'H',
	'K', 'L', 'M', 'N', 'P', 'Q',
	'R', 'S', 'T', 'V', 'X',
	
	};
    public final char[] phuAm = {
        'B','C','D','Đ','G','H','K','L','M','N','P','Q','R','S','T','V','X',
        'b','c','d','đ','g','h','k','l','m','n','p','q','r','s','t','v','x',
    };
    
    public final char[] chuSo = {'0','1','2','3','4','5','6','7','8','9'};
    
    public final char[] dauCau = {',','.','?','!',';',':','"','(',')'};
    
    public boolean isNguyenAm(char ch) {
        for (int i=0; i<nguyenAm.length; i++) {
            if (ch == nguyenAm[i]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isPhuAm(char ch) {
        for (int i=0; i<phuAm.length; i++) {
            if (ch == phuAm[i]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isDauCau(char ch) {
        for (int i=0; i<dauCau.length; i++) {
            if (ch == dauCau[i]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isChuSo(char ch) {
        for (int i=0; i<chuSo.length; i++) {
            if (ch == chuSo[i]) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean checkExist(String x){
        for (char ch : x.toCharArray()) {
            if (!isPhuAm(ch)&&!isNguyenAm(ch)&&!isDauCau(ch)) return false;
        }
        return true;
    }      
    
    public boolean checkMaxMinPhuAm(String x) {
        int sl = 0;
        for (char ch : x.toCharArray()) {
            if (isPhuAm(ch)) sl++;
        }
        return (sl >= MIN_SL_PHU_AM && sl <= MAX_SL_PHU_AM) ? true : false;
    }
    
    public boolean checkMaxMinNguyenAm(String x) {
        int sl = 0;
        for (char ch : x.toCharArray()) {
            if (isNguyenAm(ch)) sl++;
        }
        return (sl >= MIN_SL_NGUYEN_AM && sl <= MAX_SL_NGUYEN_AM) ? true : false;
    }
    
    public boolean checkPhuAmCuoi(String x) {
        char[] array = x.toCharArray();
        char cuoi = array[array.length-1];
        for (int i = 0; i<notPhuAmCuoi.length; i++) {
            if(array.length>=2){
                if (cuoi == notPhuAmCuoi[i]) {
                    return false;
                } else if (isDauCau(cuoi)&&array[array.length-2]==notPhuAmCuoi[i]){
                    return false;
                }
            }
        }
        return true;
    }
    
/*
    public void showInfoRule() {
        System.out.println("Số lượng nguyên âm = " + nguyenAm.length /2);
        System.out.println("Số lượng phụ âm = " + phuAm.length /2);
        System.out.println("Số lượng phụ âm có thể đứng cuối = " + (phuAm.length/2 - notPhuAmCuoi.length/2));
        System.out.println("Số lượng phụ âm không thể đứng cuối = " + notPhuAmCuoi.length/2);
        System.out.println("Số lượng tối thiểu - tối đa nguyên âm: " + MIN_SL_NGUYEN_AM + " - " + MAX_SL_NGUYEN_AM);
        System.out.println("Số lượng tối thiểu - tối đa phụ âm: " + MIN_SL_PHU_AM + " - " + MAX_SL_PHU_AM);
    }
*/     

    public void show(int num) {
        //System.out.println("Từ này sai luật số " + id);
        System.out.println("Tong so loi la: " + num);
    }   
    
    public boolean checkDauCau(String x){
        char[] ch=x.toCharArray();
            for(int i=0;i<ch.length;i++) {
                if(isDauCau(ch[i])){
                    if(i!=0&&i!=(ch.length-1)){
                        if (ch[ch.length-1]=='.'&&ch[ch.length-2]=='.'&&ch[ch.length-3]=='.'&&(!isDauCau(ch[ch.length-4]))||ch[ch.length-4]==',') return true;
                        return false;
                    }else if(i==0){
                        if(ch[0]!='('&&ch[0]!='"') return false;
                    }else if(i==ch.length-1){
                        if(ch[ch.length-1]=='(') return false;
                    }
                }
            }
        return true;
    }
   
    // kiểm tra k và c đi với các từ i,e,ê và q đi với u
    public boolean checkLetterKandCandQ(String x){
        char[] ch=x.toCharArray();  
            for(int i=0;i<ch.length-1;i++) {
                //System.out.println(ch[0]);
                if(ch[i]=='k'||ch[i]=='K') {
                    if(ch[i+1]!= 'e'&&ch[i+1]!= 'è'&&ch[i+1]!= 'é'&&ch[i+1]!= 'ẻ'&&ch[i+1]!= 'ẽ'&&ch[i+1]!= 'ẹ'&&ch[i+1]!=
        'ê'&&ch[i+1]!= 'ề'&&ch[i+1]!= 'ế'&&ch[i+1]!= 'ể'&&ch[i+1]!= 'ễ'&&ch[i+1]!= 'ệ'&&ch[i+1]!=
        'i'&&ch[i+1]!= 'ì'&&ch[i+1]!= 'í'&&ch[i+1]!= 'ỉ'&&ch[i+1]!= 'ĩ'&&ch[i+1]!= 'ị'&&ch[i+1]!='h'&&ch[i+1]!='y'&&ch[i+1]!='ỳ'&&ch[i+1]!='ý'&&ch[i+1]!='ỷ'&&ch[i+1]!='ỹ'&&ch[i+1]!='ỵ') return false;
                }
                if(ch[i]=='c'||ch[i]=='C') {
                    if(ch[i+1]== 'e'||ch[i+1]== 'è'||ch[i+1]== 'é'||ch[i+1]== 'ẻ'||ch[i+1]== 'ẽ'||ch[i+1]== 'ẹ'||ch[i+1]==
        'ê'||ch[i+1]== 'ề'||ch[i+1]== 'ế'||ch[i+1]== 'ể'||ch[i+1]== 'ễ'||ch[i+1]== 'ệ'||ch[i+1]==
        'i'||ch[i+1]== 'ì'||ch[i+1]== 'í'||ch[i+1]== 'ỉ'||ch[i+1]== 'ĩ'||ch[i+1]== 'ị') return false;
                }
                if(ch[i]=='Q'||ch[i]=='q') {
                    if(ch[i+1]!='u') return false;
                }
            }
            return true;
    }
    
    public boolean checkGandGH(String x){
        char[] ch=x.toCharArray();  
            for(int i=0;i<ch.length-1;i++) {
                //System.out.println(ch[0]);
                if(ch[i]=='g'||ch[i]=='G') {
                    if(ch[i+1]== 'e'||ch[i+1]== 'è'||ch[i+1]== 'é'||ch[i+1]== 'ẻ'||ch[i+1]== 'ẽ'||ch[i+1]== 'ẹ'
                     ||ch[i+1]== 'ê'||ch[i+1]== 'ề'||ch[i+1]== 'ế'||ch[i+1]== 'ể'||ch[i+1]== 'ễ'||ch[i+1]== 'ệ'
                     ||ch[i+1]== 'í'||ch[i+1]== 'ĩ'||ch[i+1]== 'ị'
                     ||ch[i+1]== 'y'||ch[i+1]== 'ỳ'||ch[i+1]== 'ý'||ch[i+1]== 'ỷ'||ch[i+1]== 'ỹ'||ch[i+1]== 'ỵ') return false;
                    if(ch[i+1]=='h'){
                        if(ch[i+2]!= 'e'&&ch[i+2]!= 'è'&&ch[i+2]!= 'é'&&ch[i+2]!= 'ẻ'&&ch[i+2]!= 'ẽ'&&ch[i+2]!= 'ẹ'&&ch[i+2]!=
                        'ê'&&ch[i+2]!= 'ề'&&ch[i+2]!= 'ế'&&ch[i+2]!= 'ể'&&ch[i+2]!= 'ễ'&&ch[i+2]!= 'ệ'&&ch[i+2]!=
                        'i'&&ch[i+2]!= 'ì'&&ch[i+2]!= 'í'&&ch[i+2]!= 'ỉ'&&ch[i+2]!= 'ĩ'&&ch[i+2]!= 'ị'
                       ||ch[i+1]== 'y'||ch[i+1]== 'ỳ'||ch[i+1]== 'ý'||ch[i+1]== 'ỷ'||ch[i+1]== 'ỹ'||ch[i+1]== 'ỵ') return false;
                    }
                }
            }
            return true;
    }
        
    public boolean checkDMark(String x) {
	int count = 0; 			//đếm số nguyên âm kèm dấu thanh
	char[] ch = x.toCharArray();
		for(int i = 0; i < ch.length; i++)
		for(int j = 0; j < nguyenAmThanh.length; j++){
	if(ch[i] == nguyenAmThanh[j]) { 
            count++;
            }
	}
	
	if(count > 1) return false;
	return true;
    }
    
    public boolean checkUpperCase(String x) {
	char[] ch = x.toCharArray();
            for(int i = 0; i < ch.length; i++){
                for(int j = 0; j < upperCase.length; j++){
                    if(ch[i] == upperCase[j]&&i!=0&&!isDauCau(ch[0])) {
                        //count++;
                        return false;
                    }
                }
            }
        return true;
    }
    
    public boolean checkHaiPhuAm (String x) {
	char[] ch = x.toCharArray();
        for(int i = 0; i < ch.length - 1; i++){
            if( isPhuAm(ch[i]) && isPhuAm(ch[i+1])){
                if((ch[i] == 't'||ch[i] == 'T') && ch[i+1] != 'r' && ch[i+1] != 'h') return false;
                if((ch[i] == 'c'||ch[i] == 'C') && ch[i+1] != 'h') return false;
                if((ch[i] == 'n'||ch[i] == 'N') && ch[i+1] != 'g'&&ch[i+1] != 'h') return false;
                if((ch[i] == 'g'||ch[i] == 'G') && ch[i+1] != 'h') return false;
                if((ch[i] == 'p'||ch[i] == 'P') && ch[i+1] != 'h') return false;
                if(ch[i] != 't'&&ch[i] != 'T'&&ch[i] != 'c'&&ch[i] != 'C'&&ch[i] != 'n'&&ch[i] != 'N'&&ch[i] != 'g'&&ch[i] != 'G'&&ch[i] != 'k'&&ch[i] != 'K'&&ch[i]!='p'&&ch[i]!='P') return false;
            }
        }

        return true;
    }
    
    public boolean checkHaiPhuAm2 (String x) {
        char[] ch = x.toCharArray();        
        for(int i = 1; i < ch.length; i++){
            if(isPhuAm(ch[i])){
                if(ch[i]=='h'&&(ch[i-1] != 't'&&ch[i-1] != 'T'&&ch[i-1] != 'c'&&ch[i-1] != 'C'&&ch[i-1] != 'n'&&ch[i-1] != 'N'&&ch[i-1] != 'g'&&ch[i-1] != 'G'&&ch[i-1] != 'k'&&ch[i-1] != 'K')&&ch[i-1] != 'p'&&ch[i-1] != 'P') return false;
                if(ch[i]=='r'&&(ch[i-1]!='t'&&ch[i-1]!='T')) return false;
                if(ch[i]=='g'&&(ch[i-1]!='n'&&ch[i-1]!='N')) return false;
            }
        }
        return true;
    }
            
    public boolean checkValid(String x) {
        
        if (!checkPhuAmCuoi(x)) {
         return false;
        }
        
        if (!checkMaxMinNguyenAm(x)||!checkMaxMinPhuAm(x)) {
            char[] ch = x.toCharArray();
            int count = 0;
            if(ch.length == 1){
                //for(int i=0;i<ch.length;i++)
                    if(ch[0] == '-' || isChuSo(ch[0])) return true;
            } else {
                for(int i = 0; i < ch.length; i++)
                {
                    if(isChuSo(ch[i])) count++;
                }
                
                if (count == ch.length) return true;
            }
            return false;
        }      
        
        
        if (!checkExist(x)) {
         return false;
        }
        if (!checkLetterKandCandQ(x)){
        return false;
        }
        
        if(!checkGandGH(x)){
        return false;
        }
        
        if(!checkDMark(x)) {
        return false; 
        }
        
        if(!checkUpperCase(x)) {
        return false;
        }
        
        if(!checkHaiPhuAm(x)){
        return false;
        }
        if(!checkHaiPhuAm2(x)){
        return false;
        }
        return true;
    }
}


