package example.boot.mapper;

import example.boot.dto.UserResponseDto;
import example.boot.entity.PersonalAccount;
import example.boot.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto fromEntitiesToDto(PersonalAccount account, User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        responseDto.setPassword(user.getPassword());
        responseDto.setUnits(account.getUnits());
        responseDto.setAccountNumber(account.getAccountNumber());
        return responseDto;
    }
}
