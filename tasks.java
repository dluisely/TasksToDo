import java.util.Scanner;

class Tasks {

  String[] list = new String[100];

  public void addTask(String task) {
    for (int i = 0; i < list.length; i++) {
      if (list[i] != null) {
        continue;
      } else {
        list[i] = task;
        break;
      }
    }
    System.out.println("Here are your tasks for today: ");
    listTasks();
    request();
  }

  public void deleteTask(int n) {
    int taskNum = findTask(n);

    if (taskNum == -1) {
      System.out.println("Task not found.");
    }

    for(int i = taskNum; i < n - 1; i++) {
      list[i] = list[i + 1];
    }

    System.out.println("Here are your tasks for today: ");
    listTasks();
    request();
  }

  public void listTasks() {
    if (list[0] == null) {
      System.out.println("Your list is empty!");
    }
    int i = 0;
    while(list[i] != null) {
      System.out.printf("%d. %s\n", i + 1, list[i]);
      i++;
    }
  }

  public void editTask(int n, String editted) {

  }

  public int findTask(int n) {
    for (int i = 0; i < list.length; i++) {
      if (i == (n - 1)) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String args[]) {
    Tasks t = new Tasks();
    System.out.println("Hello! Here are your tasks for today:");
    t.listTasks();
    t.request();
  }

  public void request() {
    System.out.println("What would you like to do?");
    System.out.println("1.Add Task\n2.Delete Task\n3.Edit Task\n4.Exit");
    Scanner scan = new Scanner(System.in);
    int selection = scan.nextInt();
    if (selection == 1) {
      System.out.print("Type your new task: ");
      String newTask = scan.next();
      addTask(newTask);
    } else if (selection == 2) {
      System.out.println("Enter task number you want to delete: ");
      int taskNumber = scan.nextInt();
      deleteTask(taskNumber);
    } else if (selection == 3) {
      System.out.println("Enter task you wish to edit: ");
      int numEditted = scan.nextInt();
      System.out.println("Type your editted task: ");
      String edittedTask = scan.next();
      editTask(numEditted, edittedTask);
    } else {
      System.out.println("Goodbye!");
      System.exit(0);
    }

  }

}
