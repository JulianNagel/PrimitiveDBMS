import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

import java.util.Scanner;
import java.sql.DriverManager;

@ExtendWith(MockitoExtension.class)
public class DBConnectionTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private DatabaseMetaData mockMetaData;

    @Mock
    private ResultSet mockResultSet;

    @InjectMocks
    private DBConnection dbConnection;

    @BeforeAll
    public static void setup() {

    }

    @Test
    public void testEstablishConnection() throws SQLException {
        DriverManager.setLogWriter(null);
        when(mockConnection.getMetaData()).thenReturn(mockMetaData);
        when(mockMetaData.getCatalogs()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getString("TABLE_CAT")).thenReturn("test_db");

        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("test_user").thenReturn("test_password");

        DBConnection.establishConnection();

        verify(mockMetaData).getCatalogs();
        verify(mockResultSet).next();
        verify(mockResultSet).getString("TABLE_CAT");
    }

    @Test
    public void testListDatabases() throws SQLException {
        when(mockConnection.getMetaData()).thenReturn(mockMetaData);
        when(mockMetaData.getCatalogs()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getString("TABLE_CAT")).thenReturn("test_db");

        DBConnection.listDatabases(mockConnection);

        verify(mockMetaData).getCatalogs();
        verify(mockResultSet).next();
        verify(mockResultSet).getString("TABLE_CAT");
    }
}