package openagile.pms.storymanagement.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Task {

	@Id
	private int id;

	@Indexed(name = "name", unique = true)
	private String name;

	private int order;

	private String release;

	private int statusCode;

	private float estimate;

	private float todo;

	private float actual;

	private int ownerUserId;

	public Task() {

	}

	public Task(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public float getEstimate() {
		return estimate;
	}

	public void setEstimate(float estimate) {
		this.estimate = estimate;
	}

	public float getTodo() {
		return todo;
	}

	public void setTodo(float todo) {
		this.todo = todo;
	}

	public float getActual() {
		return actual;
	}

	public void setActual(float actual) {
		this.actual = actual;
	}

	public int getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(int ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
}
