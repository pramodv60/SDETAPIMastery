package com.api.models.request;

public class ProfileRequest {

	private final String address;
	private final String email;
	private final String firstName;
	private final String lastName;
	private final String mobileNumber;
	private final String username;
	private final int id;

	public ProfileRequest(Builder builder) {
		this.address = builder.address;
		this.email = builder.email; 
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.mobileNumber = builder.mobileNumber;
		this.username = builder.username;
		this.id = builder.id;
	}

	public String toString() {
		return "ProfileRequest [address=" + address + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobileNumber=" + mobileNumber + ", username=" + username + ", id=" + id + "]";
	}

	public String getAddress() { return address; }
	public String getEmail() { return email; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getMobileNumber() { return mobileNumber; }
	public String getUsername() { return username; }
	public int getId() { return id; }

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String address;
		private String email;
		private String firstName;
		private String lastName;
		private String mobileNumber;
		private String username;
		private int id;

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder mobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public ProfileRequest build() {
			return new ProfileRequest(this);
		}
	}
}