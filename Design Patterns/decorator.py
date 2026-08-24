from abc import ABC,abstractmethod

class DataSource(ABC):

    def __init__(self) -> None:
        super().__init__()

    @abstractmethod
    def write_data(self) -> None:
        print("hey from supers")
        pass
    
    @abstractmethod
    def read_data(self) -> None:
        pass

class AnotherDataSource(ABC):
    @abstractmethod
    def write_data(self) -> None:
        print("From second source")
        pass

class FileDataSource(AnotherDataSource,DataSource):



    def __init__(self,filename:str) -> None:
        self.filename = filename


    def write_data(self) -> None:
        return AnotherDataSource.write_data(self)
    
    def read_data(self) -> None:
        return super().read_data()


fd = FileDataSource("hey")
fd.write_data()