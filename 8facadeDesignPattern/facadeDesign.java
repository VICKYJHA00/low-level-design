class PowerSupply{
    public void poweron(){
        System.out.println("Power Supply is powered on");
    }
}

class CoolingSystem{
    public void startFan(){
        System.out.println("Cooling System : Fans started....");
    }
}

class Cpu{
    public void initialize(){
        System.out.println("CPU : initialization started....");
    }
}

class Memory{
    public void selftest(){
        System.out.println("Memory : self tested passed...");
    }
}

class HardDrive{
    public void spinup(){
        System.out.println("Hard Drive : spinning up");
    }
}

class BIOS{
    public void boot(Cpu cpu, Memory memory) {
        System.out.println("BIOS : booting cpu and memory checks...");
        cpu.initialize();
        memory.selftest();
    }
}

class OperatingSystem{
    public void load(){
        System.out.println("Operating System : loading into memory...");
    }
}


class ComputerFacade{
    private PowerSupply powerSupply = new PowerSupply();
    private CoolingSystem coolingSystem = new CoolingSystem();
    private Cpu cpu = new Cpu();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();
    private BIOS bios = new BIOS();
    private OperatingSystem os = new OperatingSystem();

    public void StartComputer(){
        System.out.println("---starting the computer---");
        powerSupply.poweron();
        coolingSystem.startFan();
        cpu.initialize();
        memory.selftest();
        hardDrive.spinup();
        bios.boot(cpu, memory);
        os.load();
    }
}


public class facadeDesign {
    public static void main(String[] args) {
        ComputerFacade computer1 = new ComputerFacade();
        computer1.StartComputer();
    }
}
