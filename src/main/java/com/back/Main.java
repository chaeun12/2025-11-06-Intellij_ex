package com.back;

import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);

        int lastId = 0;

        WiseSaying[] wiseSayings = new WiseSaying[100];

        int wiseSayingsLastIndex = -1;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = wiseSayingsLastIndex ; i >=0; i--) {
                    WiseSaying wiseSaying = wiseSayings[i];
                    System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);

                }
            } else if (cmd.equals("등록")) {
            System.out.print("명언 : ");
            String wiseSayingContent = scanner.nextLine().trim();
            System.out.print("작가 : ");
            String wiseSayingAuthor = scanner.nextLine().trim();

            int id = ++lastId;

            WiseSaying wiseSaying = new WiseSaying();
            wiseSaying.id = id;
            wiseSaying.content = wiseSayingContent;
            wiseSaying.author = wiseSayingAuthor;

            wiseSayings[++wiseSayingsLastIndex] = wiseSaying;

            System.out.println("%d번 명언이 등록되었습니다.".formatted(id));

             }else if(cmd.equals("삭제?id=")){
                int idToDelete = -1;

                try {
                    String idStr = cmd.substring("삭제?id=".length());
                    idToDelete = Integer.parseInt(idStr);
                }catch (NumberFormatException e){
                    System.out.println(id+"");
                }
            }

        }
        scanner.close();

    }

  }