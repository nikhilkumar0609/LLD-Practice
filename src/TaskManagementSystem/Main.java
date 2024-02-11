package TaskManagementSystem;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
        TaskManagement taskManagement = new TaskManagement();

        taskManagement.createUser("1","user1", "password123");
        taskManagement.createTask("1","Task 1", "user1", new Date());
        taskManagement.assignTask(taskManagement.getTasks().get(0).getTaskId(), taskManagement.getUsers().get(0).getUserId());
        taskManagement.trackTaskProgress(taskManagement.getTasks().get(0).getTaskId());
        taskManagement.notifyUsersAboutTaskDeadline(taskManagement.getTasks().get(0));
        
        taskManagement.createUser("2","user2", "password1234");
        taskManagement.createTask("2","Task 2", "user2", new Date());
        
        System.out.println(taskManagement.getTasks());
        System.out.println(taskManagement.getUsers());
    }
}
