import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== ToDoリストアプリへようこそ ===");

        while (running) {
            System.out.println("\n【操作を選択してください】");
            System.out.println("1: タスクを追加");
            System.out.println("2: タスク一覧を表示");
            System.out.println("3: タスクを削除");
            System.out.println("4: 終了");
            System.out.print("番号を入力: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask(scanner);
                    break;
                case "2":
                    showTasks();
                    break;
                case "3":
                    deleteTask(scanner);
                    break;
                case "4":
                    running = false;
                    System.out.println("アプリを終了します。");
                    break;
                default:
                    System.out.println("無効な入力です。1〜4の番号を選んでください。");
            }
        }

        scanner.close();
    }

    // タスクを追加するメソッド
    private static void addTask(Scanner scanner) {
        System.out.print("追加するタスクを入力してください: ");
        String task = scanner.nextLine();
        if (task.trim().isEmpty()) {
            System.out.println("空のタスクは追加できません。");
        } else {
            tasks.add(task);
            System.out.println("「" + task + "」を追加しました。");
        }
    }

    // タスク一覧を表示するメソッド
    private static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("現在タスクはありません。");
            return;
        }
        System.out.println("\n--- タスク一覧 ---");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    // タスクを削除するメソッド
    private static void deleteTask(Scanner scanner) {
        showTasks();
        if (tasks.isEmpty()) {
            return;
        }

        System.out.print("削除するタスクの番号を入力してください: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < tasks.size()) {
                String removed = tasks.remove(index);
                System.out.println("「" + removed + "」を削除しました。");
            } else {
                System.out.println("指定された番号のタスクは存在しません。");
            }
        } catch (NumberFormatException e) {
            System.out.println("数字で番号を入力してください。");
        }
    }
}