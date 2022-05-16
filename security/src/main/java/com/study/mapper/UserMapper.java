package com.study.mapper;

import com.study.dto.SpUser;
import com.study.dto.SpUserAtuhority;

public interface UserMapper {
	public int register(SpUser user);
	public int registerAuth(SpUserAtuhority auth);
	public SpUser read(String userid);

}
