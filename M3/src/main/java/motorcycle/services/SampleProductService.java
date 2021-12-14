package motorcycle.services;

import motorcycle.exception.NotFoundException;
import motorcycle.model.SampleProduct;
import motorcycle.repository.ISampleProductRepo;
import motorcycle.repository.SampleProductRepository;

import java.util.List;

public class SampleProductService implements ISampleProductServices {
    private ISampleProductRepo sampleProductRepo;

    public SampleProductService() {
        sampleProductRepo = new SampleProductRepository();
    }
    @Override
    public SampleProduct getById(long id) {
        SampleProduct sampleProduct = sampleProductRepo.getById(id);
        if (sampleProduct == null) {
            throw new NotFoundException("SampleProduct isn't exit!");
        }
        return sampleProduct;
    }

    @Override
    public List<SampleProduct> getSampleProduct() {
        return sampleProductRepo.getSampleProduct();
    }

    @Override
    public void addSampleProduct(SampleProduct sampleProduct) {
        if (sampleProductRepo.exist(sampleProduct.getId())) {
            throw new IllegalArgumentException("SampleProduct is exited!");
        }
        sampleProductRepo.add(sampleProduct);
    }

    @Override
    public SampleProduct updateSampleProduct(SampleProduct sampleProduct) {
        if (sampleProductRepo.exist(sampleProduct.getId())) {
            sampleProductRepo.update(sampleProduct);
        }
        return sampleProduct;
    }

    @Override
    public List<SampleProduct> selectAllSampleProduct() {
        List<SampleProduct> sampleProductList = sampleProductRepo.selectAllProduct();

        if (sampleProductList == null)
            throw new NotFoundException("Sample product not already exists");
        sampleProductRepo.selectAllProduct();


        return sampleProductList;
    }
}
