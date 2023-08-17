package com.Solution.in.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private int status; // Assuming this is an int field to represent the HTTP status code

    
    // Constructor, getters, setters, etc.

    
    public static ApiResponseBuilder builder() {
        return new ApiResponseBuilder();
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static class ApiResponseBuilder {
        private String message;
        private boolean success;
        private int status;

        public ApiResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiResponseBuilder success(boolean success) {
            this.success = success;
            return this;
        }

        public ApiResponseBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ApiResponse build() {
            ApiResponse response = new ApiResponse();
            response.setMessage(message);
            response.setSuccess(success);
            response.setStatus(status);
            return response;
        }
    }
}
