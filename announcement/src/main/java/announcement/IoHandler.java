package announcement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class IoHandler {
    BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = null;
    public IoHandler() {

    }
    public void setDate() throws IOException{
        while (date == null) {
            System.out.print("조회하고자 하는 날짜를 입력하세요 (형식: YYYY-MM-DD):  ");
            String input = brr.readLine();

            try {
                date = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("잘못된 날짜 형식입니다. 다시 입력해주세요.");
            }
        }
    }
    LocalDate getDate() {
        return date;
    }
}
