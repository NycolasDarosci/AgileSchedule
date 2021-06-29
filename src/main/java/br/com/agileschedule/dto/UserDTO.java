package br.com.agileschedule.dto;

import br.com.agileschedule.entity.User;

public class UserDTO {

	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public UserDTO EntidDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setUser(user.getEmail());
		return dto;
	}
}
