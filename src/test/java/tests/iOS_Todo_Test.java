package tests;

import PageObjects.CreateTaskPage;
import PageObjects.TasksListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class iOS_Todo_Test extends TestBase {
    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @DataProvider(name = "tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONdata
                (System.getProperty("user.dir") + "/data/TasksData.json"
                        , "Tasks Data", 2);
    }

    @Test(dataProvider = "tasks data")
    public void test_add_task(String taskName, String TaskDesc) throws MalformedURLException {
        iOS_setUp("10000", "iPhone 12 mini", "14.2",
                "46B2D918-84FF-4DD1-BE5F-4AF9EDB5D3B8", "8200");
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(TaskDesc);
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();
        tearDown();
    }

    @Test(dataProvider = "tasks data")
    public void test_add_task2(String taskName, String TaskDesc) throws MalformedURLException {
        iOS_setUp("10001", "iPhone 12 Pro Max ", "14.4",
                "19B64019-0F58-4890-AB40-F5C4DDD909C3", "8100");
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(TaskDesc);
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();
        tearDown();
    }
}
