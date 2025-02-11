package announcement;

import java.io.IOException;

public class Main {

    
    public static void main(String[] args) throws IOException {
    	IoHandler ioHandler = new IoHandler(); // input 담당자
    	ioHandler.setDate(); // 원하는 날짜 설정
    	
    	Api api = new Api(); // api호출 담당자
    	api.callToSaramin(ioHandler.getDate()); //원하는 날짜에 공고 가져오기
    	
        
    }
}
