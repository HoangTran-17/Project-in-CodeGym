package motorcycle.services;

import motorcycle.model.SampleProduct;

import java.util.List;

public interface ISampleProductServices {
    SampleProduct getById(long id);

    List<SampleProduct> getSampleProduct();

    void addSampleProduct(SampleProduct sampleProduct);

    SampleProduct updateSampleProduct(SampleProduct sampleProduct);

    List<SampleProduct> selectAllSampleProduct();
}
