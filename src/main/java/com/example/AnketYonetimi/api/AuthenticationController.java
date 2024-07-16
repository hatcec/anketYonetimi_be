package com.example.AnketYonetimi.api;


import com.example.AnketYonetimi.business.dto.AuthenticationResponse;
import com.example.AnketYonetimi.entities.User;
import com.example.AnketYonetimi.dataAccess.UserRepository;
import com.example.AnketYonetimi.services.AuthenticationService;
import com.example.AnketYonetimi.services.JwtService;
import com.example.AnketYonetimi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationService authService;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<?> createCustomer(@RequestBody AuthenticationResponse authenticationResponse) {
        return ResponseEntity.ok(authService.createCustomer(authenticationResponse));
//        if(authService.hasCustomerWithEmail(signupRequest.getEmail()))
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Email already exist. Try again with another email");
//
//        AuthenticationResponse createdUserDto = authService.createCustomer(signupRequest);
//        if (createdUserDto == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request!");
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDto);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationResponse authenticationResponse){
        return ResponseEntity.ok(authService.login(authenticationResponse));
    }
//    public AuthenticationResponse createAuthenticationToken(
//            @RequestBody AuthenticationRequest authenticationRequest
//    ) throws
//            BadCredentialsException,
//            DisabledException,
//            UsernameNotFoundException {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
//        } catch (BadCredentialsException e) {
//            throw new BadCredentialsException("Incorrect username or password.");
//        }
//        //final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
//
//    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refreshToken(@RequestBody AuthenticationResponse req){
        return ResponseEntity.ok(authService.refreshToken(req));
    }

    @GetMapping(value = "/admin/get-all-users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponse> getAllUsers(){
        return ResponseEntity.ok(authService.getAllUsers());

    }

    @GetMapping("/admin/get-users/{userId}")
    public ResponseEntity<AuthenticationResponse> getUSerByID(@PathVariable Integer userId){
        return ResponseEntity.ok(authService.getUsersById(userId));

    }

    @PutMapping("/admin/update/{userId}")
    public ResponseEntity<AuthenticationResponse> updateUser(@PathVariable Integer userId, @RequestBody User reqres){
        return ResponseEntity.ok(authService.updateUser(userId, reqres));
    }

    @GetMapping("/adminuser/get-profile")
    public ResponseEntity<AuthenticationResponse> getMyProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        AuthenticationResponse response = authService.getMyInfo(email);
        return  ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/admin/delete/{userId}")
    public ResponseEntity<AuthenticationResponse> deleteUSer(@PathVariable Integer userId){
        return ResponseEntity.ok(authService.deleteUser(userId));
    }

}
