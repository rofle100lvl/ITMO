package commands;

import CollectionManager.Flats;

import java.io.*;
import java.util.Stack;

public class ExecuteScriptCommand extends AbstractCommand {
    private static String toResources = "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    public ExecuteScriptCommand() {
        super("execute_script", "Очистка коллекции");
    }
    private Stack<String> stackOpenScripts = new Stack<>();

    public boolean findCycles(String argument){
        try {
            if(stackOpenScripts.search(argument)!=-1){
                return false;
            }
            BufferedReader reader = new BufferedReader(new FileReader(argument));
            Boolean T = true;
            stackOpenScripts.push(argument);
            String line = new String("");
            while ((line = reader.readLine()) != null) {
                if(line.split(" ").length==2 && line.split(" ")[0].equals("execute_script")){
                    T &= findCycles(toResources + line.split(" ")[1]);
                }
            }
            stackOpenScripts.pop();
            if(!T){
                System.out.println("#############################################\nОшибка! Один или несколько скриптов зациклены.\n#############################################");
            }
            return T;

        } catch (FileNotFoundException e) {
            System.out.printf("Файл %s не найден или у файла выставлены неправильные прова доступа.",argument);
            return false;

        } catch (IOException e) {
            return true;
        }
    }

    @Override
    public boolean execute(String argument) {
        return findCycles(argument);
    }
}