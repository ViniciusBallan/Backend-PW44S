package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.AddressDTO;
import br.edu.utfpr.pb.pw44s.server.mapper.AddressMapper;
import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.UserRepository;
import br.edu.utfpr.pb.pw44s.server.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("addresses")
public class AddressController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;

    public AddressController(AddressService addressService, AddressMapper addressMapper, UserRepository userRepository) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody @Valid AddressDTO dto, Authentication authentication){
        User user = currentUser(authentication);
        Address address = addressMapper.toEntity(dto);
        Address salvo = addressService.save(address, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressMapper.toDto(salvo));
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> findAll(Authentication authentication){
        User user = currentUser(authentication);
        return ResponseEntity.ok(
                addressService.findAllByUser(user)
                        .stream()
                        .map(addressMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    private User currentUser(Authentication authentication){
        return userRepository.findUserByUsername(authentication.getName());
    }
}
