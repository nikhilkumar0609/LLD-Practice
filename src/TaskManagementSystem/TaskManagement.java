package TaskManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManagement {
    private List<Task> tasks;
    private List<User> users;

    public TaskManagement() {
        this.tasks = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void createTask(String taskId, String description, String assignee, Date deadline) {
        Task task = new Task(taskId,description, assignee, deadline);
        tasks.add(task);
    }

    public void updateTask(String taskId, String description, String assignee, Date deadline, TaskStatus status) {
        Task task = findTaskById(taskId);
        if (task != null) {
            task.setDescription(description);
            task.setAssignee(assignee);
            task.setDeadline(deadline);
            task.setStatus(status);
        }
    }

    public void deleteTask(String taskId) {
        Task task = findTaskById(taskId);
        if (task != null) {
            tasks.remove(task);
        }
    }

    public void createUser(String userId, String username, String password) {
        User user = new User(userId, username, password);
        users.add(user);
    }

    public void assignTask(String taskId, String assigneeUserId) {
        Task task = findTaskById(taskId);
        User user = findUserById(assigneeUserId);

        if (task != null && user != null) {
            task.setAssignee(user.getUsername());
            user.assignTask(task);
        }
    }

    public void trackTaskProgress(String taskId) {
        Task task = findTaskById(taskId);
        if (task != null) {
            System.out.println("Task ID: " + task.getTaskId());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Assignee: " + task.getAssignee());
            System.out.println("Deadline: " + task.getDeadline());
            System.out.println("Status: " + task.getStatus());
        }
    }

    public void notifyUsersAboutTaskDeadline(Task task) {
        System.out.println("Notifying users about task deadline: " + task.getDescription());
    }

    private Task findTaskById(String taskId) {
        return tasks.stream()
                .filter(task -> task.getTaskId().equals(taskId))
                .findFirst()
                .orElse(null);
    }

    private User findUserById(String userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<User> getUsers() {
        return users;
    }
}
