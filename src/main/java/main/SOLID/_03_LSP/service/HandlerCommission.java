package main.SOLID._03_LSP.service;

import main.SOLID._03_LSP.model.TypeOperation;
import main.SOLID._03_LSP.service.commission.Commission;

public interface HandlerCommission {
    Commission getCommission(TypeOperation type);
}
