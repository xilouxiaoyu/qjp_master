package cn.itcast.gjp.service;

import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author apple
 * @date 2019/9/29 下午4:57
 */
public class ExceptionHandlingAsyncTaskExecutor implements AsyncTaskExecutor {
    private AsyncTaskExecutor executor;
    public ExceptionHandlingAsyncTaskExecutor(AsyncTaskExecutor executor) {
        this.executor = executor;
    }

    public void execute(Runnable task) {
        executor.execute(createWrappedRunnable(task));
    }
    public void execute(Runnable task, long startTimeout) {

        executor.execute(createWrappedRunnable(task), startTimeout);
    }
    public Future submit(Runnable task) {

        return executor.submit(createWrappedRunnable(task));
    }
    public Future submit(final Callable task) {

        return executor.submit(createCallable(task));
    }

    private Callable createCallable(final Callable task) {
        return new Callable() {
            public Object call() throws Exception {
                try {
                    return task.call();
                } catch (Exception ex) {
                    handle(ex);
                    throw ex;
                }
            }
        };
    }

    private Runnable createWrappedRunnable(final Runnable task) {
        return new Runnable() {
            public void run() {
                try {
                    task.run();
                } catch (Exception ex) {
                    handle(ex);
                }
            }
        };
    }
    private void handle(Exception ex) {
        //具体的异常逻辑处理的地方
        System.err.println("Error during @Async execution: " + ex);
    }
}
