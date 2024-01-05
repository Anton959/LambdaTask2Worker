public class Worker {
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCalback;
    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCalback) {
        this.callback = callback;
        this.errorCalback = errorCalback;
    }
    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 32) {
                errorCalback.onError("Task " + i + " is error");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}
