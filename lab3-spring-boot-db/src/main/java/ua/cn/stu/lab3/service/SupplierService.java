package ua.cn.stu.lab3.service;

import java.util.List;

import ua.cn.stu.lab3.entity.Supplier;

public interface SupplierService {
    Supplier create(Supplier supplier);
    Supplier update(Long id, Supplier supplier);
    void delete(Long id);
    Supplier getById(Long id);
    List<Supplier> getAll();
}
