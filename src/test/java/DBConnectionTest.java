import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

import java.util.Scanner;
import java.sql.DriverManager;


public class DBConnectionTest {
    private static final Connection mockConnection = Mockito.mock(Connection.class);

    @Test
    private void DBConnectionTest(){
        Mockito.when();
    }
}