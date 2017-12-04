package test.service;

import test.domain.Information;
import test.domain.Score;

import java.util.List;

public interface IGuardService {
Information getInformationByExamNumber(String  exmaNumber);
    List<Score> checkScoring(int serialNumber);
    List<Information> getInformationBySerialNumber(int serialNumber);
}
