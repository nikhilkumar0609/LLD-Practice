package TaskManagementSystem;

import java.util.Date;

public class Task {
    private String taskId;
    private String description;
    private String assignee;
    private Date deadline;
    private TaskStatus status;

    public Task(String taskId, String description, String assignee, Date deadline) {
        this.taskId = taskId;
        this.description = description;
        this.assignee = assignee;
        this.deadline = deadline;
        this.status = TaskStatus.TODO;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignee() {
        return assignee;
    }

    public Date getDeadline() {
        return deadline;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", description=" + description + ", assignee=" + assignee + ", deadline="
				+ deadline + ", status=" + status + "]";
	}
    
    
}