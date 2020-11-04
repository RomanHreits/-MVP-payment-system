package example.boot.mapper;

import example.boot.dto.UserResponseDto;
import example.boot.dto.UserResponseForUserPageDto;
import example.boot.entity.PersonalAccount;
import example.boot.entity.User;
import example.boot.service.PersonalAccountService;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final PersonalAccountService accountService;

    public UserMapper(PersonalAccountService accountService) {
        this.accountService = accountService;
    }

    public UserResponseDto fromEntitiesToDto(PersonalAccount account, User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        responseDto.setPassword(user.getPassword());
        responseDto.setUnits(account.getUnits());
        responseDto.setAccountNumber(account.getAccountNumber());
        return responseDto;
    }

    public UserResponseForUserPageDto fromEntityToDtoForUserPage(User user) {
        PersonalAccount account = accountService.get(user.getId());
        UserResponseForUserPageDto response = new UserResponseForUserPageDto();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setAccountNumber(account.getAccountNumber());
        return response;
    }
}
