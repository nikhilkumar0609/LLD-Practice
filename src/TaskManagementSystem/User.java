package TaskManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String username;
    private String password;
    private List<Task> assignedTasks;

    public User(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.assignedTasks = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void assignTask(Task task) {
        assignedTasks.add(task);
    }

    public void unassignTask(Task task) {
        assignedTasks.remove(task);
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", assignedTasks="
				+ assignedTasks + "]";
	}
    
    
}