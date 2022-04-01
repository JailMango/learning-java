package core.basic.chapter02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lombok.extern.slf4j.Slf4j;

/**
 * C2_7_2_序列化与反序列化
 *
 * @author jailmango
 * @CreateDate 2020/11/17
 * @see core.basic.chapter02
 * @since R9.0
 */
@Slf4j
public class C2_7_2_序列化与反序列化 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("Data.out");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Data writeData = new Data();
        writeData.setId(1);
        writeData.setName("writeData-1");
        writeData.setSalary(2000);

        log.info("Serializable...");
        oos.writeObject(writeData);
        oos.flush();
        oos.close();

        log.info("Deserializable...");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Data readData = (Data) ois.readObject();
        log.info("Data -> ID[{}], Name[{}], Salary[{}]", readData.getId(), readData.getName(), readData.getSalary());
    }
}
