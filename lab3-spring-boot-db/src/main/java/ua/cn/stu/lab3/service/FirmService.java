package ua.cn.stu.lab3.service;

import java.util.List;

import ua.cn.stu.lab3.entity.Firm;

public interface FirmService {
    Firm create(Firm firm);
    Firm update(Long id, Firm firm);
    void delete(Long id);
    Firm getById(Long id);
    List<Firm> getAll();
}
