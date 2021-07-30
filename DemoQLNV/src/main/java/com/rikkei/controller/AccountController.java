package com.rikkei.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rikkei.dto.AccountDto;
import com.rikkei.entity.Account;
import com.rikkei.form.AccountForm;
import com.rikkei.service.IAccountService;


@RestController  // kết hợp giữa @Controller và @RéponseBody giống với @Component nhưng đánh dấu cụ thể đây là tầng Controller
@RequestMapping(value = "api/v1/accounts")  //map request với class
@CrossOrigin("*")  // CORS-tiêu chuẩn bảo mật có ở trình duyệt, @CrossOrigin cho phép truy cập ở bất kì domain nào
public class AccountController {
	@Autowired
	private IAccountService accountService;

//	@GetMapping()
//	public ResponseEntity<?> getAllAccount() {
//		List<Account> entities = accountService.getAllAccount();
//		List<AccountDto> dtos = new ArrayList<>();
//		for (Account account : entities) {
//			AccountDto dto = new AccountDto(account.getAccountID(), account.getEmail(), account.getUserName(),
//					account.getFullName(), account.getDepartment().getDepartmentName(),
//					account.getPosition().getPositionName().toString(), account.getCreateDate());
//			dtos.add(dto);
//		}
//		return new ResponseEntity<List<AccountDto>>(dtos, HttpStatus.OK);
//	}
	@GetMapping()  //map request với method
	public ResponseEntity<?> getAllAccount(Pageable pageable, @RequestParam(required = false) String search) {  //@RequestParam để trích xuất dữ liệu từ parameter, Pageable hỗ trợ phân trang
		Page<Account> entities = accountService.getAllAccount(pageable, search);
		Page<AccountDto> dtoPage = entities.map(new Function<Account, AccountDto>() {
			@Override
			public AccountDto apply(Account account) {
				AccountDto dto = new AccountDto(account.getAccountID(), account.getEmail(), account.getUserName(),
						account.getFullName(), account.getDepartment().getDepartmentName(),
						account.getPosition().getPositionName().toString(), account.getCreateDate());
				return dto;
			}
		});
		return new ResponseEntity<Page<AccountDto>>(dtoPage, HttpStatus.OK); //HttpStatus là mã code server trả về mỗi lần gửi request, ở đây gửi về 200 OK
	}

	@GetMapping(value = "/{accountID}") //map request với method, @Get là để lấy dữ liệu
	public ResponseEntity<?> getAccountByID(@PathVariable short accountID) {   //@PathVariable đánh dấu khoá chính của entity muốn truy vấn
		Account account = accountService.getAccountByID(accountID);
		AccountDto dto = new AccountDto(account.getAccountID(), account.getEmail(), account.getUserName(),
				account.getFullName(), account.getDepartment().getDepartmentName(),
				account.getPosition().getPositionName().toString(), account.getCreateDate());
		return new ResponseEntity<AccountDto>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/userName/{userName}") //map request với method, @Get là để lấy dữ liệu
	public ResponseEntity<?> getAccountByUserName(@PathVariable String userName) {
		Account account = accountService.getAccountByUserName(userName);
		AccountDto dto = new AccountDto(account.getAccountID(), account.getEmail(), account.getUserName(),
				account.getFullName(), account.getDepartment().getDepartmentName(),
				account.getPosition().getPositionName().toString(), account.getCreateDate());
		return new ResponseEntity<AccountDto>(dto, HttpStatus.OK);
	}

	@PostMapping() ////map request với method, @Post đánh dấu đây là method tạo mới
	public ResponseEntity<?> createAccount(@RequestBody AccountForm accountFrom) {   //@RequestBody đánh dấu đây là phần body của request
		accountService.createAccount(accountFrom);
		return new ResponseEntity<String>("Create success", HttpStatus.CREATED);
	}

//	@GetMapping()
//	public ResponseEntity<?> getByCurrentMonth() throws ParseException {
//		return new ResponseEntity<List<Account>>(accountService.getByCurrentMonth(), HttpStatus.OK);
//	}
//
//	@GetMapping()
//	public ResponseEntity<?> getByCurrentMonthOrderByCreateDate() throws ParseException {
//		return new ResponseEntity<List<Account>>(accountService.getByCurrentMonthOrderByCreateDate(), HttpStatus.OK);
//	}
//
//	@GetMapping()
//	public ResponseEntity<?> getCountAccountByMonthOfYearNow() {
//		return new ResponseEntity<List<Object[]>>(accountService.getCountAccountByMonthOfYearNow(), HttpStatus.OK);
//	}

	@PutMapping(value = "/accountID/{accountID}")  ////map request với method, @Put dùng để sửa
	public ResponseEntity<?> updateAccount(@PathVariable(name = "accountID") short accountID,
			@RequestBody AccountForm accountForm) {   
		accountService.updateAccount(accountID, accountForm);
		return new ResponseEntity<String>("Update success", HttpStatus.OK);
	}

	@DeleteMapping(value = "/accountID/{accountID}")  //map request với method, @Delete để xoá
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "accountID") short accountID) {
		accountService.deleteAccount(accountID);
		return new ResponseEntity<String>("Delete success", HttpStatus.OK);
	}

	@GetMapping(value = "/email/{email}")
	public ResponseEntity<?> getAccountByEmail(@PathVariable String email) {
		Account account = accountService.getAccountByEmail(email);
		AccountDto dto = new AccountDto(account.getAccountID(), account.getEmail(), account.getUserName(),
				account.getFullName(), account.getDepartment().getDepartmentName(),
				account.getPosition().getPositionName().toString(), account.getCreateDate());
		return new ResponseEntity<AccountDto>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/UserNameExists/{userName}")
	public ResponseEntity<?> existsByName(@PathVariable(name = "userName") String userName) {
		return new ResponseEntity<>(accountService.existsByUserName(userName), HttpStatus.OK);
	}

	@GetMapping(value = "/EmailExists/{email}")
	public ResponseEntity<?> existsByEmail(@PathVariable(name = "email") String email) {
		return new ResponseEntity<>(accountService.existsByEmail(email), HttpStatus.OK);
	}
}
