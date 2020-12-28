package com.heyou.springcloud.sleuth.dao;


import com.heyou.springcloud.sleuth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/11/30 23:27
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
