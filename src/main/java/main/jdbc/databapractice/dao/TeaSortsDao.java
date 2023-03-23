package main.jdbc.databapractice.dao;

import main.jdbc.databapractice.model.TeaSort;

import java.util.List;
import java.util.Optional;

public interface TeaSortsDao {
    TeaSort create(TeaSort kind);
    Optional<TeaSort> get(Long id);
    Optional<TeaSort> get(String name);
    List<TeaSort> getAll();
    TeaSort update(TeaSort kind);
    boolean delete(Long id);
}
