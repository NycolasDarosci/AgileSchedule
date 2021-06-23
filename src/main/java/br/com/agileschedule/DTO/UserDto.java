package br.com.agileschedule.DTO;

import br.com.agileschedule.Entity.User;

public class UserDto {

	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public UserDto EntidDTO(User user) {
		UserDto dto = new UserDto();
		dto.setUser(user.getUserName());
		return dto;
	}
}
