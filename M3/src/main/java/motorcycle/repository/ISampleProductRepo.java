package motorcycle.repository;

import motorcycle.model.SampleProduct;

import java.util.List;

public interface ISampleProductRepo {
    SampleProduct getById(long id);

    List<SampleProduct> getSampleProduct();

    boolean exist(long id);

    void add(SampleProduct newSampleProduct);

    SampleProduct update(SampleProduct sampleProduct);

    boolean existByName(String name);

    List<SampleProduct> selectAllProduct();
}
