package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderRequestDTO;
import br.edu.utfpr.pb.pw44s.server.mapper.OrderMapper;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.UserRepository;
import br.edu.utfpr.pb.pw44s.server.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;

    public OrderController(OrderService orderService, OrderMapper orderMapper, UserRepository userRepository) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> checkout(@RequestBody @Valid OrderRequestDTO dto, Authentication authentication){
        User user = currentUser(authentication);
        Order order = orderService.checkout(dto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderMapper.toDto(order));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(Authentication authentication){
        User user = currentUser(authentication);
        return ResponseEntity.ok(
                orderService.findAllByUser(user)
                        .stream()
                        .map(orderMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    private User currentUser(Authentication authentication){
        return userRepository.findUserByUsername(authentication.getName());
    }

}
