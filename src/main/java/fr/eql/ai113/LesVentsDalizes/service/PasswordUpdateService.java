package fr.eql.ai113.LesVentsDalizes.service;

public interface PasswordUpdateService {
    void updateColumnPasswordWithBcrypt(String tableName, String columnName, int startRow, int endRow);

}
