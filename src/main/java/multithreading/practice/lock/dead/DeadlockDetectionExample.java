package multithreading.practice.lock.dead;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Process {
    private final int id;

    public Process(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void requestResource(Resource resource) {
        resource.allocate(this);
    }

    public void releaseResource(Resource resource) {
        resource.deallocate(this);
    }
}

class Resource {
    private final int id;
    private Process allocatedProcess;

    public Resource(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public synchronized void allocate(Process process) {
        if (allocatedProcess == null) {
            allocatedProcess = process;
        } else {
            System.out.println("Resource " + id + " is already allocated to Process " + allocatedProcess.getId());
        }
    }

    public synchronized void deallocate(Process process) {
        if (allocatedProcess == process) {
            allocatedProcess = null;
        }
    }

    public synchronized Process getAllocatedProcess() {
        return allocatedProcess;
    }
}

public class DeadlockDetectionExample {
    public static void main(String[] args) {
        Process process1 = new Process(1);
        Process process2 = new Process(2);
        Resource resource1 = new Resource(1);
        Resource resource2 = new Resource(2);

        // Процесс 1 запрашивает ресурсы 1 и 2
        process1.requestResource(resource1);
        process1.requestResource(resource2);

        // Процесс 2 запрашивает ресурсы 2 и 1
        process2.requestResource(resource2);
        process2.requestResource(resource1);

        // Здесь происходит блокировка, так как каждый процесс удерживает ресурс, необходимый другому
        // и ждет освобождения ресурса, который удерживает другой процесс, что приводит к мертвой блокировке.

        // Проверяем наличие мертвой блокировки
        if (isDeadlocked(process1, process2)) {
            System.out.println("Deadlock detected!");
        } else {
            System.out.println("No deadlock detected.");
        }
    }

    // Метод для обнаружения мертвой блокировки
    public static boolean isDeadlocked(Process... processes) {
        Set<Process> visited = new HashSet<>();
        for (Process process : processes) {
            if (!visited.contains(process)) {
                if (isDeadlocked(process, visited, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }

    // Рекурсивный метод для поиска мертвой блокировки
    private static boolean isDeadlocked(Process process, Set<Process> visited, Set<Process> inStack) {
        if (!visited.contains(process)) {
            visited.add(process);
            inStack.add(process);
            for (Resource resource : getResources(process)) {
                Process allocatedProcess = resource.getAllocatedProcess();
                if (allocatedProcess != null && (inStack.contains(allocatedProcess) || isDeadlocked(allocatedProcess, visited, inStack))) {
                    return true;
                }
            }
        }
        inStack.remove(process);
        return false;
    }

    // Метод для получения ресурсов, запрошенных процессом
    private static List<Resource> getResources(Process process) {
        // В данном примере вернем просто пустой список, но в реальной программе здесь будет
        // реализация, которая вернет список ресурсов, запрошенных процессом
        return Collections.emptyList();
    }
}